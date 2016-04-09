package br.com.etzero.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

public class Calculos {

	public int getDia(Date dataRegistro) {
		Calendar data = Calendar.getInstance();
		data.setTime(dataRegistro);
		return data.get(Calendar.DAY_OF_MONTH);
	}

	public int getMes(Date dataRegistro) {
		Calendar data = Calendar.getInstance();
		data.setTime(dataRegistro);
		return data.get(Calendar.MONTH) + 1;
	}

	public int getDiaAno(int dia, int mes) {
		return (275 * mes / 9 - 30 + dia) - 2;
	}

	public int getDiaAnoCorrecao(int mes, int diaAno) {
		int resul = 0;

		if (mes > 3) {
			resul = diaAno;
		} else {
			resul = diaAno + 2;
		}

		return resul;
	}

	/**
	 * Retorna Calculo da distancia relativa terra-sol (EQ-12).
	 * 
	 * @param diaAnoCorrigido
	 *            int : dia do ano corrigido.
	 * @return double : distancia relativa terra-sol.
	 */
	public double distRelTerraSol(int diaAnoCorrigido) {
		double distRelTerraSol = 1 + 0.033 * (Math.cos((2 * Math.PI / 365) * diaAnoCorrigido));

		return round(distRelTerraSol);
	}

	/**
	 * Calcula a declinação solar (EQ-13).
	 * 
	 * @param diaAno
	 *            int: dia do ano sem correções.
	 * @return double : declinação solar.
	 */
	public double declinSolar(int diaAno) {
		double declinSolar = 0.409 * (Math.sin((((2 * Math.PI) / 365) * diaAno) - 1.39));

		return round(declinSolar);
	}

	/**
	 * Calcula a média de temperatura.
	 * 
	 * @param tempMin
	 *            double : temperatura minima registrada.
	 * @param tempMax
	 *            double : temperatura maxima registrada.
	 * @return double : media de temperatura.
	 */
	public double mediaTemp(double tempMin, double tempMax) {
		return round((tempMin + tempMax) / 2);
	}

	/**
	 * calcula a media de pressão de saturação do vapor (EQ-17);
	 * 
	 * @param pressSatVaporTempMin
	 *            double :
	 * @param pressSatVaporTempMax
	 *            double :
	 * @return double : pressão de saturação do vapor;
	 */
	public double pressSatVapor(double pressSatVaporTempMin, double pressSatVaporTempMax) {
		return round((pressSatVaporTempMin + pressSatVaporTempMax) / 2);
	}

	/**
	 * Calcula a pressão do vapor atual (EQ-18)
	 * 
	 * @param pressSatVapor
	 *            double:
	 * @param umidadeRelativa
	 *            double:
	 * @return double: pressSatVaporAtual;
	 */
	public double pressVaporAtual(double pressSatVapor, double umidadeRelativa) {
		return round(pressSatVapor * (umidadeRelativa / 100));
	}

	/**
	 * calcula a constante de Stefan-Boltzmann a diferentes temperaturas (EQ-7)
	 * 
	 * @param temperatura
	 *            : double temperatura maxima ou minima
	 * @return double : constante de Stefan-Boltzmann a diferentes temperaturas
	 */
	public double constanteStefanBoltzmann(double temperatura) {
		return round(((4.903) * Math.pow(10, -9)) * (Math.pow((temperatura + 273.16), 4)));
	}

	/**
	 * Calcula valor decimal de latitude
	 * 
	 * @param hemisferio
	 *            String : n = norte; s=sul
	 * @param latitudeGrau
	 *            double : graus;
	 * @param latitudeMinuto
	 *            double : minutos
	 * @return double : valor decimal de latitude calculado com base no
	 *         hemisfério
	 */
	public double latitudeDec(String hemisferio, double latitudeGrau, double latitudeMinuto) {
		if (hemisferio.equalsIgnoreCase("n")) {
			return round(latitudeGrau + (latitudeMinuto / 60));
		} else {
			return round((latitudeGrau + (latitudeMinuto / 60)) * -1);
		}
	}

	/**
	 * Calcula o valor da latitude em radianos (EQ-11)
	 * 
	 * @param latitudeDec
	 *            double : valor decimal da latitude;
	 * @return double : valor em radianos da latitude;
	 */
	public double latitudeRad(double latitudeDec) {
		return round((Math.PI / 180) * latitudeDec);
	}

	/**
	 * Calcula o angulo na hora do por do sol (EQ-14).
	 * 
	 * @param latitudeRad
	 *            double : valor de latitude em radianos.
	 * @param declinSolar
	 *            double : valor da declinação solar.
	 * @return double : anguloPorSol.
	 */
	public double anguloPorSol(double latitudeRad, double declinSolar) {
		return round(Math.acos(-(Math.tan(latitudeRad)) * Math.tan(declinSolar)));
	}

	/**
	 * Calcula a radiação solar extra-terrestre (EQ-10).
	 * 
	 * @param distRelTerraSol
	 *            double: distancia relativa inversa terra-sol.
	 * @param anguloPorSol
	 *            double : angulo na hora do pôr-do-sol.
	 * @param latitudeRad
	 *            double : valor de latitude em radianos.
	 * @param declinSolar
	 *            double : valor da declinação solar.
	 * @return double : radiação solar extra-terrestre
	 */
	public double radSolarExtraterrestre(double distRelTerraSol, double anguloPorSol, double latitudeRad,
			double declinSolar) {

		return round(((24 * 60) / Math.PI) * 0.08020
				* (distRelTerraSol * ((anguloPorSol * Math.sin(latitudeRad) * Math.sin(declinSolar))
						+ (Math.cos(latitudeRad) * Math.cos(declinSolar) * Math.sin(anguloPorSol)))));

	}

	/**
	 * Calcula a radiação solar recebida em céu claro (EQ-8).
	 * 
	 * @param radSolarExtraterrestre
	 *            double : radiação solar extraterrestre.
	 * @param altitude
	 *            double : altitude.
	 * @return double : radiação solar recebida em céu claro.
	 */
	public double radSolarCeuClaro(double radSolarExtraterrestre, double altitude) {
		return round((0.75 + (2 * (altitude / 100000))) * radSolarExtraterrestre);
	}

	/**
	 * Calcula a radiação de onda curta recebida (EQ-4).
	 * 
	 * @param radSolarGlobal
	 *            double : radiação solar global.
	 * @return double : radOndaCurta.
	 */
	public double radOndaCurta(double radSolarGlobal) {
		return round((0.77 * radSolarGlobal));
	}

	/**
	 * Calcula a radiação de onda longa (EQ-5).
	 * 
	 * @param constStefanTempMin
	 *            double : constante para temperatura minima.
	 * @param constStefanTempMax
	 *            double : constante para temperatura maxima.
	 * @param pressVaporAtual
	 *            double : pressão do vapor atual.
	 * @param radSolarGlobal
	 *            double : radiação solar global recebida.
	 * @param radSolarCeuClaro
	 *            double : radiação solar recebida em céu claro.
	 * @return double : radOndaLonga.
	 */
	public double radOndaLonga(double constStefanTempMin, double constStefanTempMax, double pressVaporAtual,
			double radSolarGlobal, double radSolarCeuClaro) {
		return round(((constStefanTempMin + constStefanTempMax) / 2) * (0.34 - 0.14 * Math.sqrt(pressVaporAtual))
				* (1.35 * (radSolarGlobal / radSolarCeuClaro) - 0.35));
	}

	/**
	 * Calcula a radiação líquida na superfície da cultura (EQ-3).
	 * 
	 * @param radOndaCurta
	 *            double : radiação de onda curta.
	 * @param radOndaLonga
	 *            double : radiacao de onda longa.
	 * @return double : radLiquidaCultura.
	 */
	public double radLiquidaCultura(double radOndaCurta, double radOndaLonga) {
		return round(radOndaCurta - radOndaLonga);
	}

	/**
	 * Calcula a declividade da curva de pressão do vapor de saturação (EQ-2).
	 * 
	 * @param mediaTemp
	 *            double : media entre temperatura maxima e mínima.
	 * @return double : declividade da curva de pressão do vapor de saturação.
	 */
	public double declivCurvaPressao(double mediaTemp) {
		return round((4098 * (0.6108 * Math.exp((17.27 * mediaTemp) / (mediaTemp + 237.3))))
				/ Math.pow((mediaTemp + 237.3), 2));
	}

	/**
	 * Calcula a pressão atmosférica para diferentes altitudes(EQ-16).
	 * 
	 * @param altitude
	 *            double : altitude (m).
	 * @return double : pressão atmosférica.
	 */
	public double pressaoAtm(double altitude) {
		return round(101.3 * Math.pow((293 - 0.0065 * altitude) / 293, 5.26));
	}

	/**
	 * Calcula a constante psicrométrica (EQ-15).
	 * 
	 * @param pressaoAtm
	 *            double : pressao atmosférica para diferentes altitudes.
	 * @return double : constante psicrométrica.
	 */
	public double constPsicrometrica(double pressaoAtm) {
		return round((0.665 * Math.pow(10, -3)) * pressaoAtm);
	}

	/**
	 * Calcula a pressão de saturação do vapor para diferentes temperaturas.
	 * 
	 * @param temperatura
	 *            double : temperatura.
	 * @return double : pressão de saturação do vapor para diferentes
	 *         temperaturas.
	 */
	public double pressSatVaporTemp(double temperatura) {
		return round(0.6108 * Math.exp((17.27 * temperatura) / (temperatura + 237.3)));
	}

	/**
	 * Calcula radiação solarGlobal (EQ-6).
	 * 
	 * @param radiacaoSolar
	 *            double :
	 * @return double : radiação solar global.
	 */
	public double radSolarGlobal(double radiacaoSolar) {
		return round(radiacaoSolar * 0.0864);
	}

	/**
	 * Calcula a velocidade do vento.
	 * 
	 * @param velocidade
	 *            double : velocidade do vento.
	 * @return double : velocidade do vento.
	 */
	public double velocVento(double velocidade) {
		return round(velocidade * 86.4);
	}

	/**
	 * Calcula o valor do ETO
	 * 
	 * @param radLiquidaCultura
	 * @param mediaTemp
	 * @param velocidadeVento
	 * @param pressSatVapor
	 * @param pressVaporAtual
	 * @param declivCurvaPressao
	 * @param constPsicrometrica
	 * @return double : Valor ETO
	 */
	public double ETO(double radLiquidaCultura, double mediaTemp, double velocidadeVento, double pressSatVapor,
			double pressVaporAtual, double declivCurvaPressao, double constPsicrometrica) {

		return round((0.408 * declivCurvaPressao * radLiquidaCultura
				+ constPsicrometrica * (900 / (mediaTemp + 273)) * velocidadeVento * (pressSatVapor - pressVaporAtual))
				/ (declivCurvaPressao + constPsicrometrica * (1 + 0.34 * velocidadeVento)), 3);

	}

	// arredonda para tres casas decimais
	public double round(double value) {
		BigDecimal bd = new BigDecimal(value).setScale(3, RoundingMode.UP);

		return bd.doubleValue();

	}

	public double round(double value, int scale) {
		BigDecimal bd = new BigDecimal(value).setScale(scale, RoundingMode.UP);

		return bd.doubleValue();

	}
}
