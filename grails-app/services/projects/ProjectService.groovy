package projects

class ProjectService {

    def getProjectsByCategoryId(Integer categoryId) {
        return Project.findAllByCategoryId(categoryId)
    }
}
