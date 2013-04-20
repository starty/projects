package projects

//import InvalidCategoryException

class ProjectService {

    def categoryService

    def getProjectByProjectId ( Integer projectId) {

        return Project.findByProjectId(projectId)
    }

    def createProject ( projectJson) {

        Project project = new Project()

        project.setSiteId(projectJson.siteId)
        project.setTitle(projectJson.title)
        project.setCategoryId(projectJson.categoryId)
        //Location location
        project.setStatus(projectJson.status)
        //Set rewards = []
        project.setVideoUrl(projectJson.videoUrl)
        project.setDescription(projectJson.description)
        project.setRiskAndChallenges(projectJson.riskAndChallenges)
        if (this.validateCategory(projectJson.categoryId).equals( true )  )
           project.setCategoryId(projectJson.categoryId)
        else
        throw new Exception("No se ha encontrado la categoria buscada") as Throwable

        project.setUserId(projectJson.userId)
        project.setStartDate(Date.parse("ddMMyyyy", projectJson.startDate))
        project.setEndDate(Date.parse("ddMMyyyy",projectJson.endDate))

        project.setGoalAmount(projectJson.goalAmount)
        project.setBackedUserQty(projectJson.backedUserQty)
        project.setBackedAmount(projectJson.backedAmount)
        project.setTimeToGo(projectJson.timeToGo)

        project.setCreationDate(Date.parse("ddMMyyyy",projectJson.creationDate))
        project.setLastUpdated (Date.parse("ddMMyyyy",projectJson.lastUpdated ))

        project.save(flush:true)
        return project

    }

    def validateCategory (Integer categoryId){
        categoryService.getCategory (categoryId)
    }

    def getProjectsByCategoryId(Integer categoryId) {

        return Project.findAllByCategoryId(categoryId)
    }
}
