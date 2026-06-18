package ejercicios.cuatro;

public interface EstadoOrden {

    void agregarProducto(OrdenDeCompra orden, Producto producto);

    void confirmarCompra(OrdenDeCompra orden);

    void enviar(OrdenDeCompra orden);

    void cancelar(OrdenDeCompra orden);

    OrdenDeCompra.Estado nombre();
}