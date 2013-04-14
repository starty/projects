package projects

import grails.converters.JSON

class ProjectController {

    def getProject() {
    Project project = new Project()
    project.setProjectId(12)
    project.setName("BlairWitch")

        response.status = 200
        render project  as JSON
        //return [response : project ]


    }
}
