import com.sun.org.apache.bcel.internal.generic.GETFIELD

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')

        "/$projectId" (controller: "project") {
                action =  [GET: "getProjectById"]

       }
        "/" (controller: "project") {
            action =  [POST: "createProject"]

        }

        "/category/$categoryId" (controller: "project") {
            action =  [GET: "getProjectsByCategory"]

        }


    }
}
