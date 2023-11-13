package br.com.passeioseguroapi.model;

import br.com.passeioseguroapi.dao.ModeloPreDefinidoDAO;

public class ModeloPreDefinido {
	private int idModelo;
	private String nomeMarca;
	private String nomeModelo;
	
	public ModeloPreDefinido() {
		
	}

	public ModeloPreDefinido(int idModelo, String nomeMarca, String nomeModelo) {
		super();
		setIdModelo(idModelo);
		setNomeMarca(nomeMarca);
		setNomeModelo(nomeModelo);
	}

	public int getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}
	
	public String registrarModeloPreDefinido(ModeloPreDefinido modeloPreDefinido, ModeloPreDefinidoDAO modeloPreDefinidoDao) {
		String mensagem = validarCamposObrigatorios(modeloPreDefinido);
		try {
			if (mensagem == null) {
				return modeloPreDefinidoDao.inserirModeloPreDefinido(modeloPreDefinido);
			} else {
				throw new Exception(mensagem);
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	private static String validarCamposObrigatorios(ModeloPreDefinido modeloPreDefinido) {
		if (modeloPreDefinido.getNomeMarca() == null || modeloPreDefinido.getNomeMarca().isEmpty()) {
			return "Marca é obrigatório.";
		} else if (modeloPreDefinido.getNomeModelo() == null || modeloPreDefinido.getNomeModelo().isEmpty()) {
			return "Modelo é obrigatório";
		}
		return null;
	}
}
