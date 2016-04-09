package br.com.etzero.entity.crud;

import java.util.Date;

public class RegistroEto {

	private int CodRegistro;
	private Date DataRegistro;
	private double TempMax;
	private double TempMin;
	private double UmidRelativa;
	private double veloVento;
	private double radSolar;
	private double ETO;
	private int CodEstacao;

	public int getCodRegistro() {
		return CodRegistro;
	}

	public void setCodRegistro(int CodRegistro) {
		this.CodRegistro = CodRegistro;
	}

	public Date getDataRegistro() {
		return DataRegistro;
	}

	public void setDataRegistro(Date DataRegistro) {
		this.DataRegistro = DataRegistro;
	}

	public double getTempMax() {
		return TempMax;
	}

	public void setTempMax(double TempMax) {
		this.TempMax = TempMax;
	}

	public double getTempMin() {
		return TempMin;
	}

	public void setTempMin(double TempMin) {
		this.TempMin = TempMin;
	}

	public double getUmidRelativa() {
		return UmidRelativa;
	}

	public void setUmidRelativa(double UmidRelativa) {
		this.UmidRelativa = UmidRelativa;
	}

	public double getveloVento() {
		return veloVento;
	}

	public void setveloVento(double veloVento) {
		this.veloVento = veloVento;
	}

	public double getradSolar() {
		return radSolar;
	}

	public void setradSolar(double radSolar) {
		this.radSolar = radSolar;
	}

	public double getETO() {
		return ETO;
	}

	public void setETO(double ETO) {
		this.ETO = ETO;
	}

	public int getCodEstacao() {
		return CodEstacao;
	}

	public void setCodEstacao(int CodEstacao) {
		this.CodEstacao = CodEstacao;
	}

	@Override
	public String toString() {
		return "RegistroEto [CodRegistro=" + CodRegistro + ", DataRegistro=" + DataRegistro + ", TempMax=" + TempMax
				+ ", TempMin=" + TempMin + ", UmidRelativa=" + UmidRelativa + ", veloVento=" + veloVento + ", radSolar="
				+ radSolar + ", ETO=" + ETO + ", CodEstacao=" + CodEstacao + "]";
	}

}