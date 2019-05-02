package com.sample.service;

import static spark.Spark.get;
import static spark.Spark.port;

public class SampleService {

    public static void main(String[] args) {
        port(4999);
        get("/test", (req, res) -> "Storm\tDC\tOroro Munroe es la hija de David Munroe, un reportero gráfico norteamericano, y de N'Dare, la princesa de una tribu africana de Kenia. A la edad de seis meses se fueron a vivir a El Cairo, ya que su padre trabajaba como corresponsal en esa ciudad. Cinco años más tarde estalló una guerra civil en Egipto, y a causa de uno de los bombardeos de la ciudad, la casa donde vivían quedó destruida con ellos dentro. Ororo presenció la muerte de sus padres atrapada entre las ruinas y aquella experiencia le provocó un profundo trauma, a raíz del cual desarrolló una fuerte claustrofobia. \r\nCapitan America\tMarvel\tSteve Rogers… Nacido en USA, elevado ha apreciar los ideales de la democracia, dotado con un físico superhumano, y llevado a ser el más capacitado combatiente del mundo. En solitario o como líder de los Vengadores, el lucha por la libertad y la justicia.");
    }
}
