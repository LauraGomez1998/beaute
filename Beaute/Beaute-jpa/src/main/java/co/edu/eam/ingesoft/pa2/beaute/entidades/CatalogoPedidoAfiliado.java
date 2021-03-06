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

import co.edu.eam.ingesoft.pa2.beaute.pks.CatalogoPedidoAfiliadoPK;

@Entity
@Table(name = "CATALOGO_PEDIDO_AFI")
@IdClass(value = CatalogoPedidoAfiliadoPK.class)
@NamedQueries({
		@NamedQuery(name = CatalogoPedidoAfiliado.LISTAR_PEDIDO_AFILIADO, query = "select c from CatalogoPedidoAfiliado c where c.pedido.afiliado.cedulaAfiliado=?1 and c.cantidad>0"),
		@NamedQuery(name = CatalogoPedidoAfiliado.BUSCAR_PEDIDO_AFILIADO, query = "select c from CatalogoPedidoAfiliado c where c.pedido.codigo=?1 and c.catalogo.producto.codigo=?2") })
public class CatalogoPedidoAfiliado implements Serializable {


	public static final String LISTAR_PEDIDO_AFILIADO = "CatalogoPedido.listarPedidos";

	public static final String BUSCAR_PEDIDO_AFILIADO = "CatalogoPedido.buscar";
	@Id
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "CATALOGO", referencedColumnName = "catalogo", nullable = false),
			@JoinColumn(name = "PRODUCTO", referencedColumnName = "producto", nullable = false) })
	private CatalogoProducto catalogo;

	@Id
	@ManyToOne
	@JoinColumn(name = "PEDIDO", nullable = false)
	private Pedido pedido;

	@Column(name = "CANTIDAD", length = 20, nullable = false)
	private int cantidad;

	public CatalogoPedidoAfiliado() {
	}

	public CatalogoPedidoAfiliado(CatalogoProducto catalogo, Pedido pedido, int cantidad) {
		super();
		this.catalogo = catalogo;
		this.pedido = pedido;
		this.cantidad = cantidad;
	}

	public CatalogoProducto getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(CatalogoProducto catalogo) {
		this.catalogo = catalogo;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
