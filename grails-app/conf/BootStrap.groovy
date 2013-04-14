import grails.converters.JSON
import ProjectMarshaller
import projects.Project

class BootStrap {

    def init = { servletContext ->
        JSON.registerObjectMarshaller(Project) {ProjectMarshaller.marshall(it)}
    }
    def destroy = {
    }
}
