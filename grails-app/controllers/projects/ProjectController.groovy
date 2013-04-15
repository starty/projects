package projects

import grails.converters.JSON

class ProjectController {

    def projectService

    def getProjectbyId() {
    Project project = new Project()
    project.setProjectId(12)
    project.setTitle("BlairWitch")

        response.status = 200
        render project  as JSON
        //return [response : project ]
    }

    def createProject ()   {
        Project project = new Project()

        project.setTitle("Ale")
        project.setCategoryId(56)
        project.save(flush:true)

        // Project project2 = new Project()
        //project.setProjectId(34)
        //project.setTitle("Javi")
        //project.setCategoryId(99)
        // project.save(flush:true)

        //Project project3 = new Project()
        // project.setProjectId(56)
        // project.setTitle("Alan")
        // project.setCategoryId(99)
       // project.save(flush:true)

        response.status = 200
        render "" //this.getProjectsByCategory(99) as JSON


    }

    //def getProjectBySite    (String siteId) {}
    def getProjectsByCategory  (String categoryId) {
        response.status = 200
        render projectService.getProjectsByCategoryId(categoryId)  as JSON
    }



    }

