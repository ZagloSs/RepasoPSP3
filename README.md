Haz un cliente y un servidor (multicliente). El servidor elige un número aleatorio al arrancar. Los clientes pueden ir enviando números para tratar de averiguarlo. Cuando un cliente lo acierta, este gana, se cierran las conexiones (para cada cliente, su hilo del server espera a que llegue el intento de acierto, lo ignora y le manda el mensaje de fin porque ha perdido) y se terminan el servidor y los clientes.
