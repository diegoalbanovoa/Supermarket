package models;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Diego Fernando Alba Novoa
 * @date 26 jun 2022
 * 
 *       <tittle> <b> Client</b></tittle><br>
 *       <br>
 *       Clase encargada de administrar los clientes que ingresan.
 */
public class Client {

	private ArrayList<Product> products;
	private Random random;

	public Client() {
		this.random = new Random();
		this.products = new ArrayList<Product>();
		this.addProductRandom();

	}

	/**
	 * <tittle> <b> addProductRandom </b></tittle><br>
	 * <br>
	 * Método encargado de cargar los productos del cliente aleatoriamente.
	 */
	public void addProductRandom() {
		int prctNum = random.nextInt(20);
		for (int i = 0; i < prctNum; i++) {
			products.add(new Product());
		}
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public int getProductSize() {
		return this.products.size();
	}
}
