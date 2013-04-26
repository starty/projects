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
        project.setBackedUserQty(0)
        project.setBackedAmount(0)
        project.setTimeToGo(1) /* TODO HACER DIFERENCIAS DE FECHAS*/

        project.setCreationDate(new Date () )
        project.setLastUpdated (new Date () )

        project.save(flush:true)
        return project

    }

    def validateCategory (Integer categoryId){

        categoryService.getCategoryById (categoryId)
    }

    def getProjectsByCategoryId(Integer categoryId) {
        if (!categoryService.getCategoryById (categoryId)) {
            System.out.println ("Finded")
            return Project.findAllByCategoryId(categoryId)
        }
        else
            System.out.println ("Not Finded")
    }

    def getProjectsByUserId(Integer userId) {

        return Project.findAllByUserId(userId)

    }
}
