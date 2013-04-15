package projects

class Project {

    Integer projectId
   // String siteId
    String title
    Integer categoryId
 //   Location location
  //  String status
    //Set rewards = []
  //  String videoUrl
    //  String description
    //String riskAndChallenges

    //Integer userId
    // Date startDate
    //Date endDate

    //Long goalAmount
    //Long backedUserQty
    //Long backedAmount
    //Long secondsToGo

    //Date creationDate
    //Date lastUpdated


    static constraints = {
        projectId(unique: true, blank:false)
        title(blank: false, maxSize: 100)

        //   siteId  (nullable: true)

         categoryId   (nullable: true)
      //   location (nullable: true)
        // status  (nullable : true)
         //rewards (nullable: true)
        // videoUrl    (nullable: true)
        // description   (nullable: true)
        //riskAndChallenges    (nullable: true)

        //userId     (nullable: true)
        //startDate   (nullable: true)
        //endDate   (nullable: true)

        //goalAmount  (nullable: true)
        //backedUserQty   (nullable: true)
        //backedAmount   (nullable: true)
        //secondsToGo   (nullable: true)

        //creationDate (nullable: true)
        //lastUpdated   (nullable: true)


    }

    static mapping = {
        table 'project'
        version false
        id name: 'projectId'
    }



}
