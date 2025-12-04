package mx.edu.uteq.idgs12.microservicio_division;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Microservicio de División y Programas Educativos
 * Gestiona divisiones académicas y programas educativos (carreras)
 * 
 * Migrado a:
 * - Clever Cloud MySQL (base de datos compartida)
 * - Eureka Service Discovery
 * - API Gateway compatible
 * 
 * @version 2.0 - MySQL & Eureka Integration with Programa Educativo
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicioDivisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioDivisionApplication.class, args);
		
		System.out.println("\n╔════════════════════════════════════════════════════════════╗");
		System.out.println("║                                                            ║");
		System.out.println("║     MICROSERVICIO DE DIVISIÓN Y PROGRAMAS INICIADO         ║");
		System.out.println("║                                                            ║");
		System.out.println("║  Servicio: division-service                                ║");
		System.out.println("║  Puerto: 8085                                              ║");
		System.out.println("║  Database: Clever Cloud MySQL                              ║");
		System.out.println("║  Eureka: http://localhost:8761                             ║");
		System.out.println("║                                                            ║");
		System.out.println("║  === DIVISIONES ===                                        ║");
		System.out.println("║  API Base: http://localhost:8085/api/divisiones            ║");
		System.out.println("║  • GET    /api/divisiones            [Listar todas]        ║");
		System.out.println("║  • GET    /api/divisiones/{id}       [Obtener por ID]      ║");
		System.out.println("║  • POST   /api/divisiones            [Crear división]      ║");
		System.out.println("║  • PUT    /api/divisiones/{id}       [Actualizar]          ║");
		System.out.println("║  • DELETE /api/divisiones/{id}       [Eliminar]            ║");
		System.out.println("║                                                            ║");
		System.out.println("║  === PROGRAMAS EDUCATIVOS ===                              ║");
		System.out.println("║  API Base: http://localhost:8085/api/programas-educativos  ║");
		System.out.println("║  • GET    /api/programas-educativos  [Listar todos]        ║");
		System.out.println("║  • GET    /api/programas-educativos/{id} [Por ID]          ║");
		System.out.println("║  • GET    /api/programas-educativos/division/{divisionId}  ║");
		System.out.println("║           [Por división]                                   ║");
		System.out.println("║  • POST   /api/programas-educativos  [Crear programa]      ║");
		System.out.println("║  • PUT    /api/programas-educativos/{id} [Actualizar]      ║");
		System.out.println("║  • DELETE /api/programas-educativos/{id} [Eliminar]        ║");
		System.out.println("║                                                            ║");
		System.out.println("║  Vía API Gateway:                                          ║");
		System.out.println("║  http://localhost:8080/division-service/api/...            ║");
		System.out.println("║                                                            ║");
		System.out.println("║  🎓 UTEQ - Sistema de Asistencias 2025                     ║");
		System.out.println("║                                                            ║");
		System.out.println("╚════════════════════════════════════════════════════════════╝\n");
	}

}