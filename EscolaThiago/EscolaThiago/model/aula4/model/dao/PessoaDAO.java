package aula4.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import aula4.app.DB;
import aula4.ctrl.exception.PessoaException;
import aula4.model.entities.Pessoa;

public class PessoaDAO {

	// CREATE
	public Pessoa inserir(Pessoa pessoa) throws PessoaException {

		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO tb_pessoa " + "(nm_pessoa, cpf, dt_nascimento)" + "VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, pessoa.getNmPessoa());
			st.setLong(2, pessoa.getCpf());
			st.setDate(3, new Date(pessoa.getDtNascimento().getTime()));

			int rowsAffected = st.executeUpdate();
			System.out.println("Linhas alteradas: " + rowsAffected);

			if (rowsAffected > 0) {

				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					pessoa.setIdPessoa(id);
				}
			}
		} catch (SQLException e) {
			throw new PessoaException(e.getMessage());
		}

		return pessoa;
	}

	// READ
	public List<Pessoa> buscaTodos() throws PessoaException {
		ResultSet rs = null;
		PreparedStatement st = null;
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			Connection conn = DB.getConnection();

			String query = "SELECT id_pessoa, nm_pessoa, cpf, dt_nascimento FROM tb_pessoa ORDER BY nm_pessoa ";
			st = conn.prepareStatement(query);

			rs = st.executeQuery();

			while (rs.next()) {
				pessoas.add(this.vo(rs));
			}

		} catch (SQLException e) {
			throw new PessoaException(e.getMessage());

		}

		return pessoas;
	}

	private Pessoa vo(ResultSet rs) throws SQLException {
		Pessoa pessoa = new Pessoa();

		pessoa.setIdPessoa(rs.getInt("id_pessoa"));
		pessoa.setNmPessoa(rs.getString("nm_pessoa"));
		pessoa.setCpf(rs.getLong("cpf"));
		pessoa.setDtNascimento(rs.getDate("dt_nascimento"));
		return pessoa;
	}

	public Pessoa buscaPorId(Integer id) throws PessoaException {
		Pessoa pessoa = null;

		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();
			
			String query = "SELECT id_pessoa, nm_pessoa, cpf, dt_nascimento FROM tb_pessoa WHERE id_pessoa = ? ";
			st = conn.prepareStatement(query);
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				pessoa = this.vo(rs);
			}

		} catch (SQLException e) {
			throw new PessoaException(e.getMessage());

		}

		return pessoa;
	}

	// UPDATE

	public Pessoa alterar(Pessoa pessoa) throws PessoaException {

		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();

			String query = "UPDATE tb_pessoa SET nm_pessoa = ?, cpf = ?, dt_nascimento = ? WHERE id_pessoa = ? ; ";
			st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, pessoa.getNmPessoa());
			st.setLong(2, pessoa.getCpf());
			st.setDate(3, new Date(pessoa.getDtNascimento().getTime()));
			st.setInt(4, pessoa.getIdPessoa());
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Linhas alteradas: " + rowsAffected);

		} catch (SQLException e) {
			throw new PessoaException(e.getMessage());
		}

		return pessoa;
	}

	// DELETE

	public void excluir(Integer id) throws PessoaException {
		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();

			String query = " DELETE FROM tb_pessoa WHERE id_pessoa = ? ; ";
			st = conn.prepareStatement(query);
			st.setInt(1, id);
			int rowsAffected = st.executeUpdate();
			System.out.println("Linhas alteradas: " + rowsAffected);

		} catch (SQLException e) {
			throw new PessoaException(e.getMessage());
		}

	}
}
