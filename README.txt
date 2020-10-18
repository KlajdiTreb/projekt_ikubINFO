------------------------------------------------------
|                STRUKTURA E PROJEKIT                |
------------------------------------------------------
projekti_ikubINFO								// Parent - Packages
	├── Controller								// FirstModule - Packages
	|	├── scr
	| 	|    ├── main
	|	|    |    ├── java/com.projekti_ikubINFO
	|	|    |	  |	├── controller
	|	|    |	  |	|	├── DepartamentController		// RequestMapping for CREATE/READ/UPDATE/DELETE (CRUD)
	|	|    |	  |	|	├── PunonjesController			// RequestMapping for CREATE/READ/UPDATE/DELETE (CRUD)
	|	|    |	  |	|	└── RolesController			// RequestMapping for CREATE/READ/UPDATE/DELETE (CRUD)
	|	|    |	  |	└── TestProject_ikubINFO			// Main Class for the project
	|	|    |	  └── resources
	|	|    |		   ├── application.properties			// DatabaseConnection
	|	|    |		   └── logback.xml				// xml file for logger for debug/error
	|	|    └── test/java/com.projekti_ikubINFO
	|	|		└── test
	|	|		      └── RolesControllerTest			// Unit Tests for Roles Class
	|	└── pom.xml							// pom.xml file for Controller Module
	|
	├── logs								// logs folder generated from logback.xml
	├── Services-Repository							// SecondModule - Packages
	|	├── scr
	| 	|    └── main/java/com.projekti_ikubINFO
	|	|    		├── entity
	|	|    		|	├── Departament				// Departament class with his fields (id_departament, emri_departament)
	|	|		|	├── Punonjes				// Punonjes class with his fields (id_punonjes, emri_punonjes, mbiemri_punonjes, password, email, departament, roles)
	|	|		|	└── Roles				// Roles class with his fields (id_role, emri_role)
	|	|		├── exceptions
	|	|		|	├── ErrorDetails			// ErrorsDetails class with his fields (message, details, time)
	|	|		|	├── GlobalExceptionHandler
	|	|		|	└── ResourceNotFoundException
	|	|		├── repository	
	|	|		|	├── DepartamentRepository		// Interfaces DepRepo
	|	|		|	├── PunonjesRepository			// Interfaces PunjRepo
	|	|		|	└── RolesRepository			// Interfaces RolRepo
	|	|		├── security
	|	|		|	└── SecurityConfiguration		// Security for APIs with static user and password
	|	|		└── services
	|	|			├── DepartamentServices			// CREATE/READ/UPDATE/DELETE (CRUD) operation methods
	|	|			├── PunonjesServices			// CREATE/READ/UPDATE/DELETE (CRUD) operation methods
	|	|			└── RolesServices			// CREATE/READ/UPDATE/DELETE (CRUD) operation methods
	|	└── pom.xml							// pom.xml file for Services-Repository Module
	└──  pom.xml								// pom.xml file for projekt_ikubINFO Parent Module, containing all the necessary dependencies



RUN >> TestProject_ikubINFO

Provide authentication in Postman => user: "admin" 
			  	     password: "1230" 

---------------------------------------------------------------------------------------------------------
-----------------------------------PunonjesController : RequestMapping-----------------------------------
---------------------------------------------------------------------------------------------------------
GET:    Method, url => "/api/punonjes/all"			// URL to get all Punonjes
GET:    Method, url => "/api/punonjes/{id}"			// URL to get specific Punonjes by id
PUT:    Method, url => "/api/punonjes//update/{id}"		// URL to update specific Punonjes by id
POST:   Method, url => "/api/punonjes/add"			// URL to add Punonjes
DELETE: Method, url => "/api/punonjes/delete/{id}		// URL to delete specific Punonjes by id


------------------------------------------------------------------------------------------------------------
-----------------------------------DepartamentController : RequestMapping-----------------------------------
------------------------------------------------------------------------------------------------------------
GET:    Method, url => "/api/departament/all"			// URL to get all Departament
GET:    Method, url => "/api/departament/{id}"			// URL to get specific Departamentby id
PUT:    Method, url => "/api/departament//update/{id}"		// URL to update specific Departamentby id
POST:   Method, url => "/api/departament/add"			// URL to add Departament
DELETE: Method, url => "/api/departament/delete/{id}		// URL to delete specific Departamentby id


----------------------------------------------------------------------------------------------------
-----------------------------------RolesController : RequestMapping---------------------------------
----------------------------------------------------------------------------------------------------
GET:    Method, url => "/api/roles/all"				// URL to get all Roles
GET:    Method, url => "/api/roles/{id}"			// URL to get specific Rolesby id
PUT:    Method, url => "/api/roles//update/{id}"		// URL to update specific Rolesby id
POST:   Method, url => "/api/roles/add"				// URL to add Roles
DELETE: Method, url => "/api/roles/delete/{id}			// URL to delete specific Rolesby id























