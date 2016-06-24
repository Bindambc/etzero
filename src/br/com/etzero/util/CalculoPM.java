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
package br.com.etzero.util;

import br.com.etzero.entity.crud.Estacao;
import br.com.etzero.entity.crud.RegistroEto;
import br.com.etzero.util.Calculos;

public class CalculoPM {

	private br.com.etzero.entity.crud.Estacao estacao;
	private RegistroEto registro;

	private int dia;
	private int mes;
	private int diaAno;
	private int diaAnoCorrigido;
	private double radSolarGlobal;
	private double velocVento;
	private double distRelTerraSol;
	private double declinSolar;
	private double mediaTemp;
	private double pressSatVaporTempMin; // /////
	private double pressSatVaporTempMax;// /////
	private double pressSatVapor;
	private double pressVaporAtual;
	private double constStefanTempMax;
	private double constStefanTempMin;
	private double latitudeDec;
	private double latitudeRad;
	private double anguloPorSol;
	private double radSolarExtraterrestre;
	private double radSolarCeuClaro;
	private double radOndaCurta;
	private double radOndaLonga;
	private double radLiquidaCultura;
	private double declivCurvaPressao; // final
	private double pressaoAtm;
	private double constPsicrometrica; // final

	// //////////////////////////

	private double ETO;

	// //////////////////////////

	public CalculoPM(Estacao estacao, RegistroEto registro) {
		this.estacao = estacao;
		this.registro = registro;

		calcular();
		imprimir();
	}

	public void imprimir() {

		System.out.println("dia: " + dia);
		System.out.println("mes: " + mes);
		System.out.println("diaAno: " + diaAno);
		System.out.println("diaAnoCorrigido: " + diaAnoCorrigido);

		System.out.println("distRelTerraSol: " + distRelTerraSol);
		System.out.println("declinaSolar: " + declinSolar);
		System.out.println("mediaTemp: " + mediaTemp);
		System.out.println("Pressão sat temp minima: " + pressSatVaporTempMin);
		System.out.println("Pressão sat temp minima: " + pressSatVaporTempMax);
		System.out.println("pressSatuVapor: " + pressSatVapor);
		System.out.println("pressSatuVaporAtual: " + pressVaporAtual);
		System.out.println("constStefanTempMax: " + constStefanTempMax);
		System.out.println("constStefanTempMin: " + constStefanTempMin);
		System.out.println("latitudeDec: " + latitudeDec);
		System.out.println("latitudeRad: " + latitudeRad);
		System.out.println("anguPorSol: " + anguloPorSol);
		System.out.println("radSolarExtraterrestre: " + radSolarExtraterrestre);
		System.out.println("radSolarCeuClaro: " + radSolarCeuClaro);
		System.out.println("radOndaCurtaRecebida: " + radOndaCurta);
		System.out.println("radOndaLongaRecebida: " + radOndaLonga);
		System.out.println("radLiquidaCultura: " + radLiquidaCultura);
		System.out.println("decliviCurvaPresaVapor: " + declivCurvaPressao);
		System.out.println("Pressão atmosférica: " + pressaoAtm);
		System.out.println("constPsicrometrica: " + constPsicrometrica);

		System.out.println("radSolar: " + radSolarGlobal);
		System.out.println("velocVento: " + velocVento);
		// double dec = new BigDecimal(ETO).setScale(3,
		// BigDecimal.ROUND_DOWN).doubleValue();
		// dec.format(ETO);
		System.out.println("ETO: " + ETO);

	}

	private void calcular() {

		Calculos calc = new Calculos();

		this.dia = calc.getDia(registro.getDataRegistro());

		this.mes = calc.getMes(registro.getDataRegistro());

		this.diaAno = calc.getDiaAno(dia, mes);

		this.diaAnoCorrigido = calc.getDiaAnoCorrecao(mes, diaAno);

		this.radSolarGlobal = calc.radSolarGlobal(registro.getradSolar());

		this.velocVento = calc.velocVento(registro.getveloVento());

		this.distRelTerraSol = calc.distRelTerraSol(diaAnoCorrigido);

		this.declinSolar = calc.declinSolar(diaAno);

		this.mediaTemp = calc.mediaTemp(registro.getTempMin(), registro.getTempMax());

		this.pressSatVaporTempMin = calc.pressSatVaporTemp(registro.getTempMin());

		this.pressSatVaporTempMax = calc.pressSatVaporTemp(registro.getTempMax());

		this.pressSatVapor = calc.pressSatVapor(pressSatVaporTempMin, pressSatVaporTempMax);

		this.pressVaporAtual = calc.pressVaporAtual(pressSatVapor, registro.getUmidRelativa());

		this.constStefanTempMin = calc.constanteStefanBoltzmann(registro.getTempMin());

		this.constStefanTempMax = calc.constanteStefanBoltzmann(registro.getTempMax());

		this.latitudeDec = calc.latitudeDec(estacao.getHemisferio(), estacao.getLatitudeGrau(),
				estacao.getLatitudeMinuto());

		this.latitudeRad = calc.latitudeRad(latitudeDec);

		this.anguloPorSol = calc.anguloPorSol(latitudeRad, declinSolar);

		this.radSolarExtraterrestre = calc.radSolarExtraterrestre(distRelTerraSol, anguloPorSol, latitudeRad,
				declinSolar);

		this.radSolarCeuClaro = calc.radSolarCeuClaro(radSolarExtraterrestre, estacao.getAltitude());

		this.radOndaCurta = calc.radOndaCurta(radSolarGlobal);

		this.radOndaLonga = calc.radOndaLonga(constStefanTempMin, constStefanTempMax, pressVaporAtual, radSolarGlobal,
				radSolarCeuClaro);

		this.radLiquidaCultura = calc.radLiquidaCultura(radOndaCurta, radOndaLonga);

		this.declivCurvaPressao = calc.declivCurvaPressao(mediaTemp);

		this.pressaoAtm = calc.pressaoAtm(estacao.getAltitude());

		this.constPsicrometrica = calc.constPsicrometrica(pressaoAtm);

		this.ETO = calc.ETO(radLiquidaCultura, mediaTemp, registro.getveloVento(), pressSatVapor, pressVaporAtual,
				declivCurvaPressao, constPsicrometrica);
		this.registro.setETO(this.ETO);
	}

}
