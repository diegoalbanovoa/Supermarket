package controllers;

import java.util.ArrayList;
import models.Client;
import views.Constants;

/**
 * @author Diego Fernando Alba Novoa
 * @date 25 jun 2022<br>
 *       <br>
 * 
 *       <tittle><b> Supermarket</b></tittle><br>
 *
 *       Clase encargada de administrar la parte lógica del supermercado, usando
 *       las cajas, los clientes y los productos como objetos.
 */
public class Supermarket {
	private ArrayList<CashRegister> listCashRegister;

	/**
	 * <tittle> Supermarket </tittle> Método se encargada de inicializar las
	 * variables del objeto Supermarket.
	 * 
	 * @param amountCashRegister Cantidad de Cajas para la atención
	 */
	public Supermarket(int amountCashRegister) {
		this.listCashRegister = new ArrayList<>(amountCashRegister);
		this.addCashRegister(amountCashRegister);
	}

	/**
	 * <tittle> <b>addCashRegister </b></tittle><br>
	 * <br>
	 * Método encargado de crear y agregar la cantidad de cajas registradoras a la
	 * lista de cajas
	 * 
	 * @param amountCashRegister
	 */
	public void addCashRegister(int amountCashRegister) {
		for (int i = 0; i < amountCashRegister; i++) {
			this.listCashRegister.add(new CashRegister(Constants.CASH_REGISTER_NAME + (i + 1)));
		}
	}

	/**
	 * <tittle> <b>attentClients </b></tittle><br>
	 * <br>
	 * Método encargado de la simulación de ingreso de clientes al supermercado
	 * donde se simulación la atención de cada uno.
	 * 
	 * @param clientsNum Numero de clientes a atender
	 * @throws InterruptedException
	 */
	public void attentClients(int clientsNum) throws InterruptedException {
		ArrayList<Client> clients = new ArrayList<>();
		for (int i = 0; i < clientsNum; i++) {
			clients.add(new Client());
		}
		synchronized (clients) {
			int loop = listCashRegister.size();
			for (int i = 0; i < clients.size(); i++) {
				if (listCashRegister.size() == loop) {
					loop = 0;
				}
				listCashRegister.get(loop).attendClient(clients.get(i));
				clients.remove(i);
				loop = loop + 1;
			}
		}
	}

	public static void main(String[] args) {
		Supermarket s = new Supermarket(Constants.CASH_REGISTER_QUANTITY);
		try {
			s.attentClients(Constants.CASH_REGISTER_CLIENTS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
