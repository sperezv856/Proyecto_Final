package proyecto_final1;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author josep
 */
public class LogIn {

    private TipoProducto producto;
    private Cliente cliente;
    private Servicio servicio;
    private DetalleServicio detalle;
    private Guia guia;
    private Justificaciones justificaciones;
    private ObjetoGestor objetoGestor;
    private Mensajero mensajero;
    private Gestor gestor;
    private Date fechaServicio = null;
    private String observaciones = null, instrucciones = null, estado = null, userName = null, password = null;
    private int IdServicio = 0, idGuia = 0, monto = 0;
    ManejoProductos manejoProductos = new ManejoProductos();
    ManejoCliente manejoCliente = new ManejoCliente();
    ManejoMensajero manejoMensajero = new ManejoMensajero();
    ManejoGestor manejoGestor = new ManejoGestor();
    ManejoGuia manejoGuia = new ManejoGuia(30);
    ManejoJustificaciones manejoJustificaciones = new ManejoJustificaciones(15);
    ManejoRutas manejoRutas = new ManejoRutas();
    ManejoArbol manejoArbol = new ManejoArbol();
    Priorizar priorizar = new Priorizar();
    ObjetoJustificaciones objetoJustificaciones = new ObjetoJustificaciones(objetoGestor, justificaciones);
    ClienteUsuario clienteUsuario = new ClienteUsuario(cliente, userName, password);
    MensajeroUsuario mensajeroUsuario = new MensajeroUsuario(mensajero, userName, password);
    GestorUsuario gestorUsuario = new GestorUsuario(gestor, userName, password);
    
     public void IniciarDatos() {
        manejoCliente.IngresarDatosIniciales();
        manejoProductos.IngresarDatosIniciales();
    }

    public void LogIn() {
        ManejoUsuarios manejoUsuarios = new ManejoUsuarios();
        
        servicio = new Servicio(fechaServicio, observaciones, instrucciones, IdServicio);
        detalle = new DetalleServicio(idGuia, monto, observaciones, estado);
        guia = new Guia(cliente, servicio, detalle, producto);

        int opcion = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("-------- SISTEMA DE MENSAJERIA -------");
            System.out.println("------------ LOG IN -----------------");
            System.out.println("1. Ingresar al sistema");
            System.out.println("2. Crear usuario");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de usuario: ");
                    String username = scanner.next();
                    System.out.println("Ingrese su contraseña: ");
                    String password = scanner.next();
                    Usuario usuarioAutenticado = manejoUsuarios.autenticar(username, password);
                    if (usuarioAutenticado instanceof ClienteUsuario) {
                        ClienteUsuario clienteAutenticado = (ClienteUsuario) usuarioAutenticado;
                        Cliente clienteAsociado = clienteAutenticado.getCliente();
                        System.out.println("Bienvenido, " + clienteAsociado.getNombreCompleto());
                        boolean continuar = true;
                        while (continuar) {
                            System.out.println(" -------------- Opciones -----------------");
                            System.out.println("1. Ver informacion personal. ");
                            System.out.println("2. Ver lista de productos. ");
                            System.out.println("3. Crear un servicio");
                            System.out.println("4. Buscar/ Ver estado del servicio");
                            System.out.println("5. Revisar la ruta del pedido");
                            System.out.println("6. Modificar datos personales");
                            System.out.println("7. Salir");
                            System.out.println("Seleccione una opcion: ");
                            opcion = scanner.nextInt();

                            switch (opcion) {
                                case 1:
                                    System.out.println("-----------Informacion Personal---------------");
                                    System.out.println("Nombre completo: " + clienteAsociado.getNombreCompleto());
                                    System.out.println("Cedula: " + clienteAsociado.getCedula());
                                    System.out.println("Email: " + clienteAsociado.getEmail());
                                    System.out.println("Telefono: " + clienteAsociado.getCelular());
                                    System.out.println("Estado: " + clienteAsociado.getEstado());
                                    break;
                                case 2:
                                    manejoProductos.MostrarProductos();
                                    break;
                                case 3:
                                    int ced = clienteAutenticado.getCliente().getCedula();
                                    Cliente buscarCliente = manejoCliente.buscarCliente(ced);
                                    if (manejoGuia.isEstadoServicio()) {
                                        System.out.println("Opcion deshabilitada.");
                                    } else {
                                        guia = guia.CrearGuia(buscarCliente, servicio, detalle, manejoProductos);
                                        manejoGuia.push(guia);
                                    }
                                    break;
                                case 4:
                                    System.out.println("Ingrese el numero de Guia a buscar: ");
                                    int idGuia = scanner.nextInt();
                                    manejoGuia.BuscarPilaGuia(idGuia);
                                    manejoGuia.RevisarDetalle();
                                    break;
                                case 5:
                                    System.out.println("Ingrese el numero de Guia a buscar: ");
                                    idGuia = scanner.nextInt();
                                    priorizar.buscarPorId(idGuia);
                                    priorizar.mostrarRuta(idGuia);
                                    break;
                                case 6:
                                    ced = clienteAutenticado.getCliente().getCedula();
                                    manejoCliente.ModificarCliente(ced);
                                    break;
                                case 7:
                                    System.out.println("Regresando");
                                    continuar = false;

                                    break;
                            }

                        }
                    } else if (usuarioAutenticado instanceof GestorUsuario) {
                        GestorUsuario clienteAutenticado = (GestorUsuario) usuarioAutenticado;
                        Gestor gestorAsociado = clienteAutenticado.getGestor();
                        System.out.println("Bienvenido, " + gestorAsociado.getNombreCompleto());
                        boolean continuar = true;
                        while (continuar) {
                            System.out.println(" -------------- Opciones -----------------");
                            System.out.println("1. Ver informacion personal. ");
                            System.out.println("2. Buscar cliente");
                            System.out.println("3. Eliminar cliente");
                            System.out.println("4. Modificar cliente");
                            System.out.println("5. Mostrar lista de clientes");
                            System.out.println("6. Ingresar producto");
                            System.out.println("7. Buscar producto");
                            System.out.println("8. Eliminar producto");
                            System.out.println("9. Modificar producto");
                            System.out.println("10. Mostrar lista de productos");
                            System.out.println("11. Eliminar Guia");
                            System.out.println("12. Mostrar las guias");
                            System.out.println("13. Buscar Guia");
                            System.out.println("14. Priorizar Guia");
                            System.out.println("15. Ingresar una ruta");
                            System.out.println("16. Buscar una ruta");
                            System.out.println("17. Eliminar una ruta");
                            System.out.println("18. Modificar una ruta");
                            System.out.println("19. Mostrar las rutas");
                            System.out.println("20. Crear justificaciones");
                            System.out.println("21. Eliminar justificaciones");
                            System.out.println("22. Mostrar las justificaciones");
                            System.out.println("23. Buscar justificaciones");
                            System.out.println("24. Mostrar los servicios eliminados");
                            System.out.println("25. Eliminar servicios");
                            System.out.println("26. Mostrar los servicios priorizados");
                            System.out.println("27. Mostrar la cantidad de guias y justificaciones");
                            System.out.println("28. Bloquear el ingreso de guias nuevas");
                            System.out.println("29. Limpiar el sistema");
                            System.out.println("30. Salir");
                            System.out.println("Seleccione una opcion: ");
                            opcion = scanner.nextInt();

                            switch (opcion) {
                                case 1:
                                    System.out.println("-----------Informacion Personal---------------");
                                    System.out.println("Nombre completo: " + gestorAsociado.getNombreCompleto());
                                    System.out.println("Cedula: " + gestorAsociado.getCedula());
                                    System.out.println("Tipo de gestor: " + gestorAsociado.getTipoGestor());
                                    System.out.println("Funcion: " + gestorAsociado.getFunciones());
                                    System.out.println("Estado: " + gestorAsociado.getEstado());
                                    break;
                                case 2:
                                    System.out.println("Ingrese el numero de cedula a buscar: ");
                                    int ced = scanner.nextInt();
                                    manejoCliente.buscarCliente(ced);
                                    break;
                                case 3:
                                    System.out.println("Ingrese el numero de cedula a eliminar: ");
                                    ced = scanner.nextInt();
                                    manejoCliente.EliminarCliente(ced);
                                    break;
                                case 4:
                                    System.out.println("Ingrese el numero de cedula a modificar: ");
                                    ced = scanner.nextInt();
                                    manejoCliente.ModificarCliente(ced);
                                    break;
                                case 5:
                                    manejoCliente.MostrarClientes();
                                    break;
                                case 6:
                                    TipoProducto producto = manejoProductos.crearProducto();
                                    manejoProductos.IngresarProducto(producto);
                                    break;
                                case 7:
                                    System.out.println("Ingrese el numero de id a buscar: ");
                                    int cdp = scanner.nextInt();
                                    manejoProductos.buscarProducto(cdp);
                                    break;
                                case 8:
                                    System.out.println("Ingrese el numero de id a eliminar: ");
                                    cdp = scanner.nextInt();
                                    manejoProductos.EliminarProducto(cdp);
                                    break;
                                case 9:
                                    System.out.println("Ingrese el numero de id a modificar: ");
                                    cdp = scanner.nextInt();
                                    manejoProductos.ModificarProducto(cdp);
                                    break;
                                case 10:
                                    manejoProductos.MostrarProductos();
                                    break;
                                case 11:
                                    manejoGuia.popGuia();
                                    break;
                                case 12:
                                    manejoGuia.MostrarPilaGuia();
                                    break;
                                case 13:
                                    System.out.println("Ingrese el numero de Guia a buscar: ");
                                    int idGuia = scanner.nextInt();
                                    manejoGuia.BuscarPilaGuia(idGuia);
                                    break;
                                case 14:
                                    guia = manejoGuia.popGuia();
                                    System.out.println("Guia: " + guia.toString());
                                    objetoGestor.setGuia(guia);
                                    continuar = true;
                                    while (continuar) {
                                        System.out.println(" -------------- Opciones -----------------");
                                        System.out.println("1. Poner en prioridad. ");
                                        System.out.println("2. Bajar la prioridad. ");
                                        System.out.println("3. Salir");
                                        System.out.println("Seleccione una opcion: ");
                                        opcion = scanner.nextInt();
                                        switch (opcion) {
                                            case 1:
                                                priorizar.ingresarAlInicio(objetoGestor);
                                                guia.getDetalle().setEstado("En transito");
                                                break;
                                            case 2:
                                                priorizar.ingresarAlFinal(objetoGestor);
                                                guia.getDetalle().setEstado("En transito");
                                                break;
                                            case 3:
                                                System.out.println("Regresando");
                                                continuar = false;
                                        }
                                    }
                                    break;

                                case 15:
                                    Ruta ruta = manejoRutas.crearRuta();
                                    manejoRutas.IngresarRuta(ruta);
                                    break;
                                case 16:
                                    System.out.println("Ingrese el nombre de ruta a buscar: ");
                                    String rutn = scanner.nextLine();
                                    manejoRutas.BuscarRuta(rutn);
                                    break;
                                case 17:
                                    System.out.println("Ingrese el nombre de ruta a eliminar: ");
                                    rutn = scanner.nextLine();
                                    manejoRutas.EliminarRuta(rutn);
                                    break;
                                case 18:
                                    System.out.println("Ingrese el numero de Ruta a modificar: ");
                                    rutn = scanner.nextLine();
                                    manejoRutas.ModificarRuta(rutn);
                                    break;
                                case 19:
                                    manejoRutas.MostrarRuta();
                                    break;
                                case 20:
                                    manejoJustificaciones.crearJustificacion();
                                    manejoJustificaciones.push(justificaciones);
                                    manejoJustificaciones.recolector();
                                    break;
                                case 21:
                                    manejoJustificaciones.popJustificaciones();
                                    break;
                                case 22:
                                    manejoJustificaciones.MostrarPilaObjetoJustificaciones(justificaciones);
                                    break;
                                case 23:
                                    System.out.println("Ingrese el numero de Id de la justificacion a buscar: ");
                                    int idJustificacion = scanner.nextInt();
                                    manejoJustificaciones.BuscarJustificaciones(idJustificacion);
                                    break;
                                case 24:
                                    System.out.println("Servicios eliminados:");
                                    manejoArbol.MostrarEnOrden(manejoArbol.getRaiz());
                                    break;
                                case 25:
                                    System.out.println("Ingrese el id de la guia a eliminar: ");
                                    idGuia = scanner.nextInt();
                                    ObjetoGestor guiaEliminada=priorizar.eliminarPorId(idGuia);
                                    if (guiaEliminada != null) {
                                        objetoJustificaciones.CrearEntrada(guiaEliminada);
                                        manejoArbol.insertar(objetoJustificaciones);
                                    } else {
                                        System.out.println("No se ha eliminado la guia");
                                    }
                                    break;
                                case 26:
                                    priorizar.mostrarElementosPriorizados();
                                    break;
                                case 27:
                                    manejoGuia.mostrarCantElementos();
                                    manejoJustificaciones.mostrarCantElementos();
                                    break;
                                case 28:
                                    manejoGuia.estadoServicio();
                                    break;
                                case 29:
                                    manejoGuia.LimpiarGuia();
                                    manejoJustificaciones.LimpiarJustificaciones();
                                    break;
                                case 30:
                                    System.out.println("Regresando");
                                    continuar = false;

                                    break;

                            }
                        }

                    } else if (usuarioAutenticado instanceof MensajeroUsuario) {
                        MensajeroUsuario clienteAutenticado = (MensajeroUsuario) usuarioAutenticado;
                        Mensajero mensajeroAsociado = clienteAutenticado.getMensajero();
                        System.out.println("Bienvenido, " + mensajeroAsociado.getNombreCompleto());
                        boolean continuar = true;
                        while (continuar) {
                            System.out.println(" -------------- Opciones -----------------");
                            System.out.println("1. Ver informacion personal. ");
                            System.out.println("2. Realizar una accion");
                            System.out.println("3. Salir");
                            System.out.println("Seleccione una opcion: ");
                            opcion = scanner.nextInt();

                            switch (opcion) {
                                case 1:
                                    System.out.println("-----------Informacion Personal---------------");
                                    System.out.println("Nombre completo: " + mensajeroAsociado.getNombreCompleto());
                                    System.out.println("Cedula: " + mensajeroAsociado.getCedula());
                                    System.out.println("Nacionalidad: " + mensajeroAsociado.getNacionalidad());
                                    System.out.println("Codigo Mensajero: " + mensajeroAsociado.getCodigoMensajero());
                                    System.out.println("Telefono: " + mensajeroAsociado.getTelefono());
                                    System.out.println("Estado: " + mensajeroAsociado.getEstado());
                                    break;
                                case 2:

                                    break;
                                case 3:
                                    continuar = false;

                                    break;

                            }
                        }
                    } else {
                        System.out.println("Usuario no registrado.");
                    }
                    break;

                case 2:
                    System.out.println("Que tipo de cuenta desea crear? (Cliente, Gestor, Mensajero): ");
                    String tipoCuenta = scanner.next();
                    System.out.println("Ingrese el nombre de usuario: ");
                    username = scanner.next();
                    System.out.println("Ingrese su contraseña: ");
                    password = scanner.next();
                    Usuario nuevoUsuario = null;
                    if (tipoCuenta.equalsIgnoreCase("Cliente")) {
                        //ManejoCliente manejocliente = new ManejoCliente();
                        Cliente cliente = manejoCliente.crearCliente();
                        manejoCliente.IngresarCliente(cliente);
                        nuevoUsuario = new ClienteUsuario(cliente, username, password);
                        manejoUsuarios.AgregarUsuario(nuevoUsuario);
                        break;
                    } else if (tipoCuenta.equalsIgnoreCase("Mensajero")) {
                        //ManejoMensajero manejoMensajero = new ManejoMensajero();
                        Mensajero mensajero = manejoMensajero.crearMensajero();
                        manejoMensajero.IngresarMensajero(mensajero);
                        nuevoUsuario = new MensajeroUsuario(mensajero, username, password);
                        manejoUsuarios.AgregarUsuario(nuevoUsuario);
                        break;
                    } else if (tipoCuenta.equalsIgnoreCase("Gestor")) {
                        //ManejoGestor manejoGestor = new ManejoGestor();
                        Gestor gestor = manejoGestor.crearGestor();
                        manejoGestor.IngresarGestor(gestor);
                        nuevoUsuario = new GestorUsuario(gestor, username, password);
                        manejoUsuarios.AgregarUsuario(nuevoUsuario);
                        break;
                    } else {
                        System.out.println("Opcion no valida");
                    }
                    
                    break;
                case 3:
                    System.out.println("Saliendo");
                    break;
            }

        } while (opcion != 3);
    }
}
