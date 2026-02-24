rootProject.name = "salary-app-diploma"

include("user-service")
include("api-gateway")
include("service-registry")

include("user-service:application")
include("user-service:domain")
include("user-service:bootstrap")
include("user-service:adapter")
include("user-service:infrastructure")