#
# This is a Shiny web application. You can run the application by clicking
# the 'Run App' button above.
#
# Find out more about building applications with Shiny here:
#
#    http://shiny.rstudio.com/
#

library(shiny)
library(randomForest)
library(dplyr)

# Define UI for application that draws a histogram
shiny::runApp(list(
  ui=pageWithSidebar(
    headerPanel('RuTiCo - Runtime Complexity Prediction')
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
                   'Comma')
    )
    ,
    mainPanel(
      
      tableOutput(outputId = 'table.output'),
    ))
  ,
  server=function(input, output){
    output$table.output <- renderTable({
      #LOAD RDS model
      model_efficiency_merged_full <- readRDS("data/model_efficiency_classification.rds")
      model_class_merged_full <- readRDS("data/model_complexity_classification.rds")
      
      inFile <- input$file1
      
      if (is.null(inFile))
        return(NULL)
      tbl <- read.csv(inFile$datapath, header=input$header, sep=input$sep, dec = ",",stringsAsFactors=TRUE)
      database <- as.data.frame(tbl)
      tbl$p.efficiency <- predict(model_efficiency_merged_full, database)
      tbl$p.class <- predict(model_class_merged_full, database)
      result <- select(tbl, c("p.efficiency","p.class","filename"))
      return(result)
    })
  }
))