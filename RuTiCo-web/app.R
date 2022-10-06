#
# This is a Shiny web application. You can run the application by clicking
# the 'Run App' button above.
#
# Find out more about building applications with Shiny here:
#
#    http://shiny.rstudio.com/
#

library(shiny)

# Define UI for application that draws a histogram
shiny::runApp(list(
  ui=pageWithSidebar(
    headerPanel('Simple matrixInput')
    ,
    sidebarPanel(
      fileInput('file1', 'Choose CSV File',
                accept=c('text/csv', 'text/comma-separated-values,text/plain', '.csv'))
      ,
      tags$hr(),
      checkboxInput('header', 'Header', TRUE),
      radioButtons('sep', 'Separator',
                   c(Comma=',',
                     Semicolon=';',
                     Tab='\t'),
                   'Comma'),
      radioButtons('quote', 'Quote',
                   c(None='',
                     'Double Quote'='"',
                     'Single Quote'="'"),
                   'Double Quote')
    )
    ,
    mainPanel(
      
      tableOutput(outputId = 'table.output')
    ))
  ,
  server=function(input, output){
    output$table.output <- renderTable({
      #LOAD RDS model
      model_efficiency_merged_full <- readRDS(file = "model_efficiency_classification.rds")
      model_class_merged_full <- readRDS(file = "model_complexity_classification.rds")
      
      inFile <- input$file1
      
      if (is.null(inFile))
        return(NULL)
      
      tbl <- read.csv(inFile$datapath, header=input$header, sep=input$sep, quote=input$quote)
      #p.efficiency <- predict(model_efficiency_merged_full, as.data.frame(tbl))
      #p.class <- predict(model_class_merged_full, as.data.frame(tbl))
      return(tbl^2)
    })
  }
))