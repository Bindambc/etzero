package br.com.etzero.entity.views;

public class LisEstacao {

	private int CodEstacao;
	private String Descricao;
	private int LatitudeGrau;
	private int LatitudeMinuto;
	private String Hemisferio;
	private int Altitude;

	public int getCodEstacao() {
		return CodEstacao;
	}

	public void setCodEstacao(int CodEstacao) {
		this.CodEstacao = CodEstacao;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String Descricao) {
		this.Descricao = Descricao;
	}

	public int getLatitudeGrau() {
		return LatitudeGrau;
	}

	public void setLatitudeGrau(int LatitudeGrau) {
		this.LatitudeGrau = LatitudeGrau;
	}

	public int getLatitudeMinuto() {
		return LatitudeMinuto;
	}

	public void setLatitudeMinuto(int LatitudeMinuto) {
		this.LatitudeMinuto = LatitudeMinuto;
	}

	public String getHemisferio() {
		return Hemisferio;
	}

	public void setHemisferio(String Hemisferio) {
		this.Hemisferio = Hemisferio;
	}

	public int getAltitude() {
		return Altitude;
	}

	public void setAltitude(int Altitude) {
		this.Altitude = Altitude;
	}
}