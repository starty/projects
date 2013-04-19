class UrlMappings {

	static mappings = {        /*
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')     */

        "/$projectId" (controller: "project") {
           action =  [GET: "getProjectByProjectId"]

       }

        "/" (controller: "project") {
           action =  [POST: "postProject"]

        }

        "/category/$categoryId" (controller: "project") {
            action =  [GET: "getProjectsByCategory"]

        }


    }
}
