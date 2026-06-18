package ejercicios.cuatro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdenDeCompraTest {

    @org.testng.annotations.Test
    void unaOrdenNuevaComienzaIniciada() {

        OrdenDeCompra orden = new OrdenDeCompra();

        assertEquals(OrdenDeCompra.Estado.INICIADA, orden.estado());
        assertEquals(0, orden.monto());
        assertNull(orden.numeroSeguimiento());
        assertTrue(orden.productos().isEmpty());
    }

    @Test
    void sePuedenAgregarProductosCuandoLaOrdenEstaIniciada() {

        OrdenDeCompra orden = new OrdenDeCompra();

        Producto producto = new Producto("Teclado", 100);

        orden.agregarProducto(producto);

        assertEquals(1, orden.productos().size());
        assertTrue(orden.productos().contains(producto));
    }

    @Test
    void noSePuedenAgregarProductosEnPreparacion() {

        OrdenDeCompra orden = crearOrdenConfirmada();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> orden.agregarProducto(new Producto("Mouse", 50))
        );

        assertEquals(
                OrdenDeCompra.MSG_ERROR_AGREGAR_PRODUCTO,
                exception.getMessage()
        );
    }

    @Test
    void confirmarCompraCambiaElEstadoYCalculaElMonto() {

        OrdenDeCompra orden = new OrdenDeCompra();

        orden.agregarProducto(new Producto("Teclado", 100));
        orden.agregarProducto(new Producto("Mouse", 50));

        orden.confirmarCompra();

        assertEquals(
                OrdenDeCompra.Estado.EN_PREPARACION,
                orden.estado()
        );

        assertEquals(150, orden.monto());
    }

    @Test
    void noSePuedeConfirmarUnaOrdenSinProductos() {

        OrdenDeCompra orden = new OrdenDeCompra();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                orden::confirmarCompra
        );

        assertEquals(
                OrdenDeCompra.MSG_ERROR_SIN_PRODUCTOS,
                exception.getMessage()
        );
    }

    @Test
    void noSePuedeConfirmarUnaOrdenEnPreparacion() {

        OrdenDeCompra orden = crearOrdenConfirmada();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                orden::confirmarCompra
        );

        assertEquals(
                OrdenDeCompra.MSG_ERROR_PREPARACION,
                exception.getMessage()
        );
    }

    @Test
    void enviarGeneraNumeroDeSeguimiento() {

        OrdenDeCompra orden = crearOrdenConfirmada();

        orden.enviar();

        assertEquals(
                OrdenDeCompra.Estado.ENVIADA,
                orden.estado()
        );

        assertNotNull(orden.numeroSeguimiento());
        assertTrue(orden.numeroSeguimiento().startsWith("SEG-"));
    }

    @Test
    void noSePuedeEnviarUnaOrdenIniciada() {

        OrdenDeCompra orden = new OrdenDeCompra();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                orden::enviar
        );

        assertEquals(
                OrdenDeCompra.MSG_ERROR_ENVIAR,
                exception.getMessage()
        );
    }

    @Test
    void sePuedeCancelarUnaOrdenIniciada() {

        OrdenDeCompra orden = new OrdenDeCompra();

        orden.cancelar();

        assertEquals(
                OrdenDeCompra.Estado.CANCELADA,
                orden.estado()
        );
    }

    @Test
    void sePuedeCancelarUnaOrdenEnPreparacion() {

        OrdenDeCompra orden = crearOrdenConfirmada();

        orden.cancelar();

        assertEquals(
                OrdenDeCompra.Estado.CANCELADA,
                orden.estado()
        );
    }

    @Test
    void noSePuedeCancelarUnaOrdenEnviada() {

        OrdenDeCompra orden = crearOrdenConfirmada();

        orden.enviar();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                orden::cancelar
        );

        assertEquals(
                OrdenDeCompra.MSG_ERROR_CANCELAR,
                exception.getMessage()
        );
    }

    private OrdenDeCompra crearOrdenConfirmada() {

        OrdenDeCompra orden = new OrdenDeCompra();

        orden.agregarProducto(new Producto("Producto", 100));

        orden.confirmarCompra();

        return orden;
    }
}