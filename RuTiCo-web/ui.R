#
# This is the user-interface definition of a Shiny web application. You can
# run the application by clicking 'Run App' above.
#
# Find out more about building applications with Shiny here:
#
#    http://shiny.rstudio.com/
#

library(shiny)

# Define UI for app that draws a histogram ----
ui <- fluidPage(
  
  # App title ----
  titlePanel("RuTiCo - Runtime Complexity Prediction"),
  
  # Sidebar layout with input and output definitions ----
  sidebarLayout(
    
    # Sidebar panel for inputs ----
    sidebarPanel(
      
      downloadButton("downloadData", "Download Example", style = "background-color: #005266 ; border: 1px solid #005266 ; color: white"),
      
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
      
    ),
    
    # Main panel for displaying outputs ----
    mainPanel(
      
      # Output: Histogram ----
      #plotOutput(outputId = "distPlot"),
      tableOutput(outputId = 'table.output')
      
    )
  )
)