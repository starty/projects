package projects

import grails.converters.JSON

class ProjectController {

    def projectService

    def getProjectbyId() {
    //Project project = new Project()
    //project.setProjectId(12)
    //project.setTitle("BlairWitch")

        response.status = 200
        render "Method executed: getProjectbyId() "//  as JSON
        //return [response : project ]
    }

    def createProject ()   {
        Project project = new Project()

        project.setProjectId(params.projectId)
        project.setSiteId(params.siteId)
        project.setTitle(params.title)
        project.setCategoryId(params.categoryId)
        //Location location
        project.setStatus(params.status)
        //Set rewards = []
        project.setVideoUrl(params.videoUrl)
        project.setDescription(params.description)
        project.setRiskAndChallenges(params.riskAndChallenges)

        project.setUserId(params.userId)
        project.setStartDate(params.startDate)
        project.setEndDate(params.endDate)

        project.setGoalAmount(params.goalAmount)
        project.setBackedUserQty(params.backedUserQty)
        project.setBackedAmount(params.backedAmount)
        project.setTimeToGo(params.timeToGo)

        project.setCreationDate(params.creationDate)
        project.setLastUpdated(params.lastUpdated)

        project.save(flush:true)

        response.status = 200
        render "Project created" //this.getProjectsByCategory(99) as JSON


    }

    //def getProjectBySite    (String siteId) {}
    def getProjectsByCategory  (String categoryId) {
        response.status = 200
        render projectService.getProjectsByCategoryId(categoryId)  as JSON
    }



    }

