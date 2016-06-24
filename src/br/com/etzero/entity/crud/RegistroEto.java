/*The MIT License (MIT)

Copyright (c) 2016 Mauricio Binda da Costa - mauriciobc.mbc@hotmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/
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