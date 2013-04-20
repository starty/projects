package projects

import net.sf.json.groovy.JsonSlurper
import net.sf.json.JSON

class CategoryMockService {

        def getCategory (Integer categoryId){

            String key = categoryId

            //JSONObject category

            File baseDir = new File("mocks")
            File categoryFile = new File(baseDir,"cat_${key}.json")
            if(categoryFile.exists()){
                String jsonText = categoryFile.getText()
                JSON jsonParsed = parse(jsonText)
                return jsonParsed.categoryId == categoryId
            }else{
                return null
            }

        }

        def static  parse(jsonString) throws Exception {
        StringReader reader= new StringReader(jsonString);
        try {
            net.sf.json.JSON jsonParsed= new JsonSlurper().parse(reader);
            return jsonParsed;
        } catch ( e) {
            throw new Exception("Error parsing ["+jsonString+"]", e);
        }
    }

}

