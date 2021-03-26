package aula4.ctrl.negocio;

import java.util.Calendar;
import java.util.List;

import aula4.ctrl.exception.PessoaException;
import aula4.model.dao.PessoaDAO;
import aula4.model.entities.Pessoa;

public class PessoaNegocio {


		PessoaDAO dao = new PessoaDAO();
	
		public Pessoa inserir(Pessoa pessoa) throws PessoaException {
			this.validarPessoa(pessoa);
			dao.inserir(pessoa);
			return pessoa;
		}
		
		// READ
		public List<Pessoa> buscaTodos() throws PessoaException{
			return dao.buscaTodos();	
		}
		
		public Pessoa buscaPorId(Integer id) throws PessoaException {
			
			return dao.buscaPorId(id);
		}
		
		
		// UPDATE
		
		public Pessoa alterar(Pessoa pessoa) throws PessoaException {		
			this.validarPessoa(pessoa);
			return dao.alterar(pessoa);
		}
		
		// DELETE
		
		public void excluir(Integer id) throws PessoaException {
			dao.excluir(id);
		}
		
		private void validarPessoa(Pessoa pessoa) throws PessoaException {
			
			if (pessoa.getNmPessoa() == null || pessoa.getNmPessoa().length() == 0) {
				throw new PessoaException("Nome da pessoa é obrigatório.");
			}

			if (pessoa.getCpf().toString().length() != 11) {
				throw new PessoaException("CPF deve ter pelo menos 11 algarismos.");
			}
			
			Calendar calHoje = Calendar.getInstance();
			Calendar calNascimento = Calendar.getInstance();
			calNascimento.setTime(pessoa.getDtNascimento());
			
			if (calHoje.after(calNascimento)) {
				throw new PessoaException("Data de Nascimento deve ser maior que hoje.");
			}

		}
}
