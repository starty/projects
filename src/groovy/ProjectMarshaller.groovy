/**
 * Created with IntelliJ IDEA.
 * User: AlejandroVieira
 * Date: 14/04/13
 * Time: 17:41
 * To change this template use File | Settings | File Templates.
 */
import projects.Project

class ProjectMarshaller {

    static marshall(Project project){
    def projectMap = [:]
    projectMap.projectId = project.projectId
    projectMap.siteId = project.siteId
    projectMap.title  = project.title
    projectMap.categoryId  = project.categoryId //Link?
    projectMap.locationId  = project.locationId
    projectMap.status = project.status
        //Set rewards = []
    projectMap.videoUrl = project.videoUrl
    projectMap.description = project.description
    projectMap.riskAndChallenges = project.riskAndChallenges

    projectMap.userId = project.userId
    projectMap.startDate = project.startDate
    projectMap.endDate = project.endDate

    projectMap.goalAmount = project.goalAmount
      //  Set backers = []
    projectMap.backedAmount = project.backedAmount
    projectMap.timeToGo = project.timeToGo

    projectMap.creationDate = project.creationDate
    projectMap.lastUpdated  = project.lastUpdated

    return projectMap

    }
}
