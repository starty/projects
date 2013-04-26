package projects

class Project {

    Integer projectId
    String siteId
    String title
    Integer categoryId
    Integer locationId
    String status
    Set rewards = []
    String videoUrl
    String description
    String riskAndChallenges

    Integer userId
    Date startDate
    Date endDate

    Double goalAmount
    Double backedUserQty
    Double backedAmount
    Double timeToGo

    Date creationDate
    Date lastUpdated

    static hasMany = [rewards:Reward]

    static constraints = {

        // Nullable viene en false por default, quiere decir que no puede ser null
        // blank: significa que no puede ser blanco o espacios
        // size:

        projectId (unique:true, blank:false)
        title (blank:false, maxSize:100)
        siteId (blank:false )
        categoryId (blank:false)         /* como le decis a grails que exista en la de categ.         */
        locationId (blank:false)
        status (blank:false)
        videoUrl (blank:false)
        description (blank:false)
        riskAndChallenges (blank:false)
        userId (blank:false)

        startDate (blank:false) /*TO DO REVISAR FECHAS*/
        endDate (blank:false)   /*TO DO REVISAR FECHAS*/
        goalAmount (blank:false)
        backedUserQty (blank:false)
        backedAmount (blank:false)
        timeToGo (blank:false)

        creationDate (blank:false)
        lastUpdated (blank:false)
    }

    static mapping = {
        table 'project'
        version false
        id name: 'projectId'
    }

}
