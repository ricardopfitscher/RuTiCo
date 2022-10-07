#
# This is the server logic of a Shiny web application. You can run the
# application by clicking 'Run App' above.
#
# Find out more about building applications with Shiny here:
#
#    http://shiny.rstudio.com/
#

library(shiny)
library(randomForest)
library(dplyr)

# Define server logic required to draw a histogram
server <- function(input, output) {
  
  output$downloadData <- downloadHandler(
    filename <- function() {
      paste("example", "csv", sep=".")
    },
    
    content <- function(file) {
      file.copy("data/example.csv", file)
    },
    contentType = "text/csv"
  )
  
  output$table.output <- renderTable({
    #LOAD RDS model

    
    inFile <- input$file1
    
    if (is.null(inFile)){
      tbl <- read.csv("data/example.csv", sep = ",", header = T, dec = ",", stringsAsFactors=TRUE)
    }
    else{
      tbl <- read.csv(inFile$datapath, header=input$header, sep=input$sep, dec = ",",stringsAsFactors=TRUE)
    }
      
    model_efficiency_merged_full <- readRDS("data/model_efficiency_classification.rds")
    model_class_merged_full <- readRDS("data/model_complexity_classification.rds")
    database <- as.data.frame(tbl)
    tbl$p.efficiency <- predict(model_efficiency_merged_full, database)
    tbl$p.class <- predict(model_class_merged_full, database)
    result <- select(tbl, c("p.efficiency","p.class","filename"))
    return(result)
  })
  
}
