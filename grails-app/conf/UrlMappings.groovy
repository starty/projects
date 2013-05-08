class UrlMappings {

	static mappings = {


		//"/"(view:"/index")
		"500"(view:'/error')

        "/$projectId" (controller: "project") {
           action =  [GET: "getProjectByProjectId"]

       }

        "/" (controller: "project") {
           action =  [GET: "getAllProjects", POST: "postProject"]

        }

        "/category/$categoryId" (controller: "project") {
            action =  [GET: "getProjectsByCategory"]

        }

        "/users/$userId" (controller: "project") {
            action =  [GET: "getProjectsByUser"]

        }
    }
}
