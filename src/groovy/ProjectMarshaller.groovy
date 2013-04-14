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
    def map = [:]
    map.projectId = project.projectId
   // map.name = project.name
    return map

    }
}
