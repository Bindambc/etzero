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
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/package br.com.etzero.entity.crud;

import java.sql.Time;
import java.util.Date;

public class RegistroImport {

	private int idRegistroImport;
	private String estacao;
	private Date data;
	private Time hora;
	private double tempInterna;
	private double pressInst;
	private double pressMed;
	private double pressMax;
	private double pressMin;
	private double tempArInst;
	private double tempArMed;
	private double tempArMax;
	private double tempArMin;
	private double umidInst;
	private double umidMed;
	private double umidMax;
	private double umidMin;
	private double radSolInst;
	private double radSolMed;
	private double radSolMax;
	private double radSolMin;
	private double radSolSoma;
	private double umidSoloInst;
	private double umidSoloMed;
	private double umidSoloMax;
	private double umidSoloMin;
	private double tempSoloInst;
	private double tempSoloMed;
	private double tempSoloMax;
	private double tempSoloMin;
	private double dirMedMinuto;
	private double dirPicoVentoMinuto;
	private double dirCalmariaVentoMinuto;
	private double velMedMinuto;
	private double velMaxMinuto;
	private double velMinMinuto;
	private double dirMedHora;
	private double dirPicoVentoHora;
	private double dirCalmariaVentoHora;
	private double velMedHora;
	private double velMaxHora;
	private double velMinHora;
	private double preciptacao;
	private double tensBateria;

	public int getIdRegistroImport() {
		return idRegistroImport;
	}

	public void setIdRegistroImport(int idRegistroImport) {
		this.idRegistroImport = idRegistroImport;
	}

	public String getEstacao() {
		return estacao;
	}

	public void setEstacao(String estacao) {
		this.estacao = estacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public double getTempInterna() {
		return tempInterna;
	}

	public void setTempInterna(double tempInterna) {
		this.tempInterna = tempInterna;
	}

	public double getPressInst() {
		return pressInst;
	}

	public void setPressInst(double pressInst) {
		this.pressInst = pressInst;
	}

	public double getPressMed() {
		return pressMed;
	}

	public void setPressMed(double pressMed) {
		this.pressMed = pressMed;
	}

	public double getPressMax() {
		return pressMax;
	}

	public void setPressMax(double pressMax) {
		this.pressMax = pressMax;
	}

	public double getPressMin() {
		return pressMin;
	}

	public void setPressMin(double pressMin) {
		this.pressMin = pressMin;
	}

	public double getTempArInst() {
		return tempArInst;
	}

	public void setTempArInst(double tempArInst) {
		this.tempArInst = tempArInst;
	}

	public double getTempArMed() {
		return tempArMed;
	}

	public void setTempArMed(double tempArMed) {
		this.tempArMed = tempArMed;
	}

	public double getTempArMax() {
		return tempArMax;
	}

	public void setTempArMax(double tempArMax) {
		this.tempArMax = tempArMax;
	}

	public double getTempArMin() {
		return tempArMin;
	}

	public void setTempArMin(double tempArMin) {
		this.tempArMin = tempArMin;
	}

	public double getUmidInst() {
		return umidInst;
	}

	public void setUmidInst(double umidInst) {
		this.umidInst = umidInst;
	}

	public double getUmidMed() {
		return umidMed;
	}

	public void setUmidMed(double umidMed) {
		this.umidMed = umidMed;
	}

	public double getUmidMax() {
		return umidMax;
	}

	public void setUmidMax(double umidMax) {
		this.umidMax = umidMax;
	}

	public double getUmidMin() {
		return umidMin;
	}

	public void setUmidMin(double umidMin) {
		this.umidMin = umidMin;
	}

	public double getRadSolInst() {
		return radSolInst;
	}

	public void setRadSolInst(double radSolInst) {
		this.radSolInst = radSolInst;
	}

	public double getRadSolMed() {
		return radSolMed;
	}

	public void setRadSolMed(double radSolMed) {
		this.radSolMed = radSolMed;
	}

	public double getRadSolMax() {
		return radSolMax;
	}

	public void setRadSolMax(double radSolMax) {
		this.radSolMax = radSolMax;
	}

	public double getRadSolMin() {
		return radSolMin;
	}

	public void setRadSolMin(double radSolMin) {
		this.radSolMin = radSolMin;
	}

	public double getRadSolSoma() {
		return radSolSoma;
	}

	public void setRadSolSoma(double radSolSoma) {
		this.radSolSoma = radSolSoma;
	}

	public double getUmidSoloInst() {
		return umidSoloInst;
	}

	public void setUmidSoloInst(double umidSoloInst) {
		this.umidSoloInst = umidSoloInst;
	}

	public double getUmidSoloMed() {
		return umidSoloMed;
	}

	public void setUmidSoloMed(double umidSoloMed) {
		this.umidSoloMed = umidSoloMed;
	}

	public double getUmidSoloMax() {
		return umidSoloMax;
	}

	public void setUmidSoloMax(double umidSoloMax) {
		this.umidSoloMax = umidSoloMax;
	}

	public double getUmidSoloMin() {
		return umidSoloMin;
	}

	public void setUmidSoloMin(double umidSoloMin) {
		this.umidSoloMin = umidSoloMin;
	}

	public double getTempSoloInst() {
		return tempSoloInst;
	}

	public void setTempSoloInst(double tempSoloInst) {
		this.tempSoloInst = tempSoloInst;
	}

	public double getTempSoloMed() {
		return tempSoloMed;
	}

	public void setTempSoloMed(double tempSoloMed) {
		this.tempSoloMed = tempSoloMed;
	}

	public double getTempSoloMax() {
		return tempSoloMax;
	}

	public void setTempSoloMax(double tempSoloMax) {
		this.tempSoloMax = tempSoloMax;
	}

	public double getTempSoloMin() {
		return tempSoloMin;
	}

	public void setTempSoloMin(double tempSoloMin) {
		this.tempSoloMin = tempSoloMin;
	}

	public double getDirMedMinuto() {
		return dirMedMinuto;
	}

	public void setDirMedMinuto(double dirMedMinuto) {
		this.dirMedMinuto = dirMedMinuto;
	}

	public double getDirPicoVentoMinuto() {
		return dirPicoVentoMinuto;
	}

	public void setDirPicoVentoMinuto(double dirPicoVentoMinuto) {
		this.dirPicoVentoMinuto = dirPicoVentoMinuto;
	}

	public double getDirCalmariaVentoMinuto() {
		return dirCalmariaVentoMinuto;
	}

	public void setDirCalmariaVentoMinuto(double dirCalmariaVentoMinuto) {
		this.dirCalmariaVentoMinuto = dirCalmariaVentoMinuto;
	}

	public double getVelMedMinuto() {
		return velMedMinuto;
	}

	public void setVelMedMinuto(double velMedMinuto) {
		this.velMedMinuto = velMedMinuto;
	}

	public double getVelMaxMinuto() {
		return velMaxMinuto;
	}

	public void setVelMaxMinuto(double velMaxMinuto) {
		this.velMaxMinuto = velMaxMinuto;
	}

	public double getVelMinMinuto() {
		return velMinMinuto;
	}

	public void setVelMinMinuto(double velMinMinuto) {
		this.velMinMinuto = velMinMinuto;
	}

	public double getDirMedHora() {
		return dirMedHora;
	}

	public void setDirMedHora(double dirMedHora) {
		this.dirMedHora = dirMedHora;
	}

	public double getDirPicoVentoHora() {
		return dirPicoVentoHora;
	}

	public void setDirPicoVentoHora(double dirPicoVentoHora) {
		this.dirPicoVentoHora = dirPicoVentoHora;
	}

	public double getDirCalmariaVentoHora() {
		return dirCalmariaVentoHora;
	}

	public void setDirCalmariaVentoHora(double dirCalmariaVentoHora) {
		this.dirCalmariaVentoHora = dirCalmariaVentoHora;
	}

	public double getVelMedHora() {
		return velMedHora;
	}

	public void setVelMedHora(double velMedHora) {
		this.velMedHora = velMedHora;
	}

	public double getVelMaxHora() {
		return velMaxHora;
	}

	public void setVelMaxHora(double velMaxHora) {
		this.velMaxHora = velMaxHora;
	}

	public double getVelMinHora() {
		return velMinHora;
	}

	public void setVelMinHora(double velMinHora) {
		this.velMinHora = velMinHora;
	}

	public double getPreciptacao() {
		return preciptacao;
	}

	public void setPreciptacao(double preciptacao) {
		this.preciptacao = preciptacao;
	}

	public double getTensBateria() {
		return tensBateria;
	}

	public void setTensBateria(double tensBateria) {
		this.tensBateria = tensBateria;
	}

	@Override
	public String toString() {
		return "RegistroImport [idRegistroImport=" + idRegistroImport + ", estacao=" + estacao + ", data=" + data
				+ ", hora=" + hora + ", tempInterna=" + tempInterna + ", pressInst=" + pressInst + ", pressMed="
				+ pressMed + ", pressMax=" + pressMax + ", pressMin=" + pressMin + ", tempArInst=" + tempArInst
				+ ", tempArMed=" + tempArMed + ", tempArMax=" + tempArMax + ", tempArMin=" + tempArMin + ", umidInst="
				+ umidInst + ", umidMed=" + umidMed + ", umidMax=" + umidMax + ", umidMin=" + umidMin + ", radSolInst="
				+ radSolInst + ", radSolMed=" + radSolMed + ", radSolMax=" + radSolMax + ", radSolMin=" + radSolMin
				+ ", radSolSoma=" + radSolSoma + ", umidSoloInst=" + umidSoloInst + ", umidSoloMed=" + umidSoloMed
				+ ", umidSoloMax=" + umidSoloMax + ", umidSoloMin=" + umidSoloMin + ", tempSoloInst=" + tempSoloInst
				+ ", tempSoloMed=" + tempSoloMed + ", tempSoloMax=" + tempSoloMax + ", tempSoloMin=" + tempSoloMin
				+ ", dirMedMinuto=" + dirMedMinuto + ", dirPicoVentoMinuto=" + dirPicoVentoMinuto
				+ ", dirCalmariaVentoMinuto=" + dirCalmariaVentoMinuto + ", velMedMinuto=" + velMedMinuto
				+ ", velMaxMinuto=" + velMaxMinuto + ", velMinMinuto=" + velMinMinuto + ", dirMedHora=" + dirMedHora
				+ ", dirPicoVentoHora=" + dirPicoVentoHora + ", dirCalmariaVentoHora=" + dirCalmariaVentoHora
				+ ", velMedHora=" + velMedHora + ", velMaxHora=" + velMaxHora + ", velMinHora=" + velMinHora
				+ ", preciptacao=" + preciptacao + ", tensBateria=" + tensBateria + "]";
	}

}