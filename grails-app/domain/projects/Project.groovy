package projects

class Project {

    Integer projectId
    String siteId
    String title
    Integer categoryId
    //Location location
    String status
    //Set rewards = []
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

    static constraints = {

        projectId (unique:true, blank:false)
        title (blank:false, maxSize:100)
        siteId (nullable:false, blank:false )
        categoryId (nullable:false)         /* como le decis a grails que exista en la de categ.         */
        //location (nullable: true)
        status (nullable:true, blank:false)
         //rewards (nullable: true)
        videoUrl (nullable:false, blank:false)
        description (nullable:false, blank:false)
        riskAndChallenges (nullable:false, blank:false)
        userId (nullable:false)

        startDate (nullable:false) /*TO DO REVISAR FECHAS*/
        endDate (nullable:false)   /*TO DO REVISAR FECHAS*/
        goalAmount (nullable:false)
        backedUserQty (nullable:false)
        backedAmount (nullable:false)
        timeToGo (nullable:false)

        creationDate (nullable:false)
        lastUpdated (nullable:false)
    }

    static mapping = {
        table 'project'
        version false
        id name: 'projectId'
    }



}
