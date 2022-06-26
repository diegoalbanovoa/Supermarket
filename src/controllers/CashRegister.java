package controllers;

import java.util.ArrayList;

import models.Client;
import models.Product;
import views.Constants;

/**
 * @author Diego Fernando Alba Novoa
 * @date 26 jun 2022
 * 
 *       <tittle> <b> CashRegister </b></tittle><br>
 *       <br>
 *       Clase encargada de administrar la caja registradora, entre sus
 *       funciones la de atender a los clientes.
 */
public class CashRegister {

	private String name;

	public CashRegister(String name) {
		this.name = name;
	}

	/**
	 * <tittle> <b>attendClient</b></tittle><br>
	 * <br>
	 * Método encargado de atender a los clientes que llegan.
	 * 
	 * @param client Cliente
	 * @throws InterruptedException
	 */
	public void attendClient(Client client) throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Constants.CASH_REGISTER_ATTENTION_MESSAGE_INITIATION + name);
				ArrayList<Product> productos = client.getProducts();
				System.out.println(Constants.QUANTITY_OF_PRODUCTS + client.getProductSize());
				for (int i = 0; i < client.getProductSize(); i++) {
					System.out.println(Constants.PRODUCT + i + Constants.TIME + productos.get(i).time);
					try {
						Thread.sleep(productos.get(i).time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Constants.CASH_REGISTER_ATTENTION_MESSAGE_ENDING + name);
			}
		}).start();
	}

}
