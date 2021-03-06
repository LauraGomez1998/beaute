package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.beaute.pks.CatalogoPedidoClientePK;

@Entity
@Table(name = "CATALOGO_PEDIDO_CL")
@IdClass(value = CatalogoPedidoClientePK.class)
@NamedQueries({
		@NamedQuery(name = CatalogoPedidoCliente.LISTAR_PRODUCTOS_PEDIDO, query = "select c from CatalogoPedidoCliente c where c.pedidoCatalogo.codigo=?1"),
		@NamedQuery(name = CatalogoPedidoCliente.LISTAR_PEDIDOS, query = "select c from CatalogoPedidoCliente c where c.pedidoCatalogo=?1") })
public class CatalogoPedidoCliente implements Serializable {

	public static final String LISTAR_PRODUCTOS_PEDIDO = "CatalogoPedido.listar";

	public static final String LISTAR_PEDIDOS = "CatalogoPedido.listarPedidosCl";

	@Id
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "CATALOGO", referencedColumnName = "catalogo", nullable = false),
			@JoinColumn(name = "PRODUCTO", referencedColumnName = "producto", nullable = false) })
	private CatalogoProducto catalogo;

	@Id
	@ManyToOne
	@JoinColumn(name = "PEDIDO_CATALOGO", nullable = false)
	private PedidoCatalogo pedidoCatalogo;

	@Column(name = "CANTIDAD", length = 20, nullable = false)
	private int cantidad;

	public CatalogoPedidoCliente() {
	}

	public CatalogoPedidoCliente(CatalogoProducto catalogo, PedidoCatalogo pedidoCatalogo, int cantidad) {
		super();
		this.catalogo = catalogo;
		this.pedidoCatalogo = pedidoCatalogo;
		this.cantidad = cantidad;
	}

	public CatalogoProducto getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(CatalogoProducto catalogo) {
		this.catalogo = catalogo;
	}

	public PedidoCatalogo getPedidoCatalogo() {
		return pedidoCatalogo;
	}

	public void setPedidoCatalogo(PedidoCatalogo pedidoCatalogo) {
		this.pedidoCatalogo = pedidoCatalogo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
