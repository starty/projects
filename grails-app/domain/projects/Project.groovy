package projects

class Project {

    Integer projectId
    String name
    String Status
    String siteId
    String userId
    Date creationDate
    Date lastUpdated

    static constraints = {
        projectId(unique: true, blank:false)
        name(blank: false, maxSize: 100)

    }

    static mapping = {
        table 'project'
        version false
        id name: 'projectId'
    }



}
