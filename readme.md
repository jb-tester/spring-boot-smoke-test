# Spring Boot smoke test

  1. Import Spring Boot project
     * _Expected result_
          - project is recognized as SB one:
          - the Spring Boot run configuration is created
          - all Spring components get the gutter icons
  2. `application.properties` file: datasource configuration
      * _Expected result_
          - the datasource configuration has the gutter icon that creates the new DS
  3. Configuration properties completion in `application.properties` file: library properties
  4. Custom configuration properties completion: check in the `application.yaml ` file
  5. Spring component gutter icons: navigate to definition, to injection point, to Spring tool window
  6. Spring view: check the components list, check filters
  7. Controllers: check inlay actions presence
  8. Controllers: check navigation to view
      * _Expected result_
          - the view is opened; the model attributes should be resolved there
  9. Controllers: check HTTP Request generation
      * _Expected result_
          - the HTTP request is generated. Check URL, body
  10. Controllers: check OpenAPI Draft generation for the class
       * _Expected result_
           - the draft is created, contains all mapping urls with correct attributes
  11. Controllers: check path variables (navigation, rename, inspections, intentions)
      * _Expected result_
          - missing parameters are detected and created, missing variables are detected, rename works
  12. Repositories: methods creating by completion
      * _Expected result_
          - the completion is available for new method names; missing parameters are detected and added
  13. Repositories: @Query annotations
      * _Expected result_
          - JPQL is autoinjected to the annotation
  14. Run in Services view
      * _Expected result_
          - the port is displayed; Actuator tabs (Beans, Health, Mappings)
  15. Spring Diagrams test: invoke from gutter icon, from the context menu, from the Spring view toolbar
  16. Edit Starters check: add/remove some dependencies
  17. Endpoints view: check the URLs presence, check the tabs
  18. Runtime beans/request mappings: check that the components get the navigable gutter icons in runtime; check the controller mapping methods runtime gutter icons
  19. Test classes: check the URLs completion/navigation for different tests 
