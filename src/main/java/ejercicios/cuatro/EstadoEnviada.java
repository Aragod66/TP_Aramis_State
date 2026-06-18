package ejercicios.cuatro;

public class EstadoEnviada implements EstadoOrden {

    @Override
    public void agregarProducto(
            OrdenDeCompra orden,
            Producto producto
    ) {
        throw new IllegalStateException(
                OrdenDeCompra.MSG_ERROR_AGREGAR_PRODUCTO
        );
    }

    @Override
    public void confirmarCompra(OrdenDeCompra orden) {
        throw new IllegalStateException(
                OrdenDeCompra.MSG_ERROR_PREPARACION
        );
    }

    @Override
    public void enviar(OrdenDeCompra orden) {
        throw new IllegalStateException(
                OrdenDeCompra.MSG_ERROR_ENVIAR
        );
    }

    @Override
    public void cancelar(OrdenDeCompra orden) {
        throw new IllegalStateException(
                OrdenDeCompra.MSG_ERROR_CANCELAR
        );
    }

    @Override
    public OrdenDeCompra.Estado nombre() {
        return OrdenDeCompra.Estado.ENVIADA;
    }
}