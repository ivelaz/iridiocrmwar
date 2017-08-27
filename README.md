# iridio crm war version
El software iridio crm es un pequeño proyecto desarrollado en Java EE con Spring Boot, Spring Data JPA, Thymeleaf e Hibernate, que permite a una empresa registrar las llamadas, recibidas y emitidas, por los clientes. 

# Base de datos MySql
Los datos necesarios para que la aplicación pueda acceder a la base de datos, pueden conocerse y modificarse en el fichero: application.yml que se encuentra en la ruta: /src/main/resources

Los datos de acceso por defecto son:

    + url:      jdbc:mysql://localhost:3306/iridiodb?useSSL=false
    + username: admin
    + password: pass
    
La base de datos puede estar completamente vacía ya que la aplicación se encargará de generar las distintas tablas necesarias para su funcionamiento.

# Deployment
Esta versión del crm genera un archivo de extensión WAR para despliegue en cualquier servidor externo (como Tomcat o GlassFish) que sea compatible con esta tecnología. La versión JAR con Tomcat embebido puede esncontrarse aquí: https://github.com/ivelaz/iridiocrm

Esta versión por defecto se desplegará en localhost:8080/iridiocrmwar. Si se desea que se despliegue en la raíz del servidor (en Tomcat) basta con modificar el archivo: server.xml que se encuentra en la carpeta "conf" de la instalación del servidor. La modificación consiste en añadir la siguiente línea antes de la etiqueta de cierre </Host> del archivo server.xml:

<Context path="" docBase="iridiocrmwar" debug="0" reloadable="true"></Context>

Por último hay que reiniciar el servidor.


