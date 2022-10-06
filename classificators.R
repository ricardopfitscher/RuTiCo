pacotes <- c("tidyverse","knitr","rgl","reshape2","jtools","lmtest","caret","pROC","ROCR","nnet",
             "cowplot","randomForest","Boruta","performanceEstimation","neuralnet",
             "RhpcBLASctl","plyr","viridis","factoextra")

if(sum(as.numeric(!pacotes %in% installed.packages())) != 0){
  instalador <- pacotes[!pacotes %in% installed.packages()]
  for(i in 1:length(instalador)) {
    install.packages(instalador, dependencies = T)
    break()}
  sapply(pacotes, require, character = T) 
} else {
  sapply(pacotes, require, character = T) 
}

database <- read.csv("database.csv", sep = ",", header = T, dec = ",", stringsAsFactors=TRUE)
database <- na.omit(database) 
#database <- select(database, -filename)
database <- select(database, -complexity)
database  <- droplevels(database)
str(database)
summary(database)
summary(database$efficiency)

database_paper <- read.csv("database_paper.csv", sep = ",", header = T, dec = ",", stringsAsFactors=TRUE)
database_paper <- na.omit(database_paper) 
#database_paper <- select(database_paper, -filename)
database_paper <- select(database_paper, -complexity)
database_paper  <- droplevels(database_paper)
str(database_paper)
summary(database_paper)
summary(database_paper$efficiency)

#select features trough boruta
set.seed(111)
boruta <- Boruta(efficiency ~ . -complexity_class -filename, data = database, doTrace = 2, maxRuns = 500)
#print(boruta)
attStats(boruta)
formula_efficiency<-getNonRejectedFormula(boruta)

#select features trough boruta
set.seed(111)
boruta <- Boruta(complexity_class ~ . -efficiency -filename, data = database, doTrace = 2, maxRuns = 500)
#print(boruta)
attStats(boruta)
formula_class<-getNonRejectedFormula(boruta)
#formula_class<- complexity_class ~ num_if + num_loof + num_binSearch + num_minMax + num_hash_set + num_recursive + num_nasted_loop + num_method + num_state

ggplot(database) + geom_bar(aes(x=complexity_class))
ggplot(database) + geom_bar(aes(x=efficiency))

database %>%
ddply(c("complexity_class"),summarize, 
      num_if = mean(num_if),
      num_loof = mean(num_loof),
      num_binSearch = mean(num_binSearch),
      num_minMax = mean(num_minMax),
      num_hash_set = mean(num_hash_set),
      num_recursive = mean(num_recursive),
      num_nasted_loop = mean(num_nasted_loop),
      num_vari = mean(num_vari),
      num_method = mean(num_method),
      num_state = mean(num_state),
      database = "crawled"
      ) -> database_summarised

database_paper %>%
  ddply(c("complexity_class"),summarize, 
        num_if = mean(num_if),
        num_loof = mean(num_loof),
        num_binSearch = mean(num_binSearch),
        num_minMax = mean(num_minMax),
        num_hash_set = mean(num_hash_set),
        num_recursive = mean(num_recursive),
        num_nasted_loop = mean(num_nasted_loop),
        num_vari = mean(num_vari),
        num_method = mean(num_method),
        num_state = mean(num_state),
        database = "Sikka et al. (2020)"
  ) -> database_paper_sum

database_compared <- rbind(database_summarised,database_paper_sum)
database_merged <- rbind(database,database_paper)
#density https://www.statmethods.net/graphs/density.html
summary(database_merged$efficiency)

ggplot(database) +
  geom_bar(aes(x=complexity_class)) +
  labs(x="",y="Number of ocurrences")+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(plot.title = element_blank(), axis.text.x=element_text(angle=90,hjust=1,vjust=0.5,size=14),text = element_text(size = 14))   

ggsave("classes.png",height=8,width = 8)



ggplot(database) +
  geom_bar(aes(x=efficiency)) +
  labs(x="",y="Number of ocurrences")+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(plot.title = element_blank(), axis.text.x=element_text(angle=90,hjust=1,vjust=0.5,size=14),text = element_text(size = 14))   

ggsave("eficiencia.png",height=8,width = 8)

ggplot(database_paper) +
  geom_bar(aes(x=complexity_class)) +
  labs(x="",y="Number of ocurrences")+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(plot.title = element_blank(), axis.text.x=element_text(angle=90,hjust=1,vjust=0.5,size=14),text = element_text(size = 14))   

ggsave("classes_paper.png",height=8,width = 8)

ggplot(database_paper) +
  geom_bar(aes(x=efficiency)) +
  labs(x="",y="Number of ocurrences")+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(plot.title = element_blank(), axis.text.x=element_text(angle=90,hjust=1,vjust=0.5,size=14),text = element_text(size = 14))   

ggsave("eficiencia_paper.png",height=8,width = 8)


ggplot(database_merged) +
  geom_bar(aes(x=complexity_class)) +
  labs(x="",y="Number of ocurrences")+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(plot.title = element_blank(), axis.text.x=element_text(angle=90,hjust=1,vjust=0.5,size=14),text = element_text(size = 14))   

ggsave("classes_merged.png",height=8,width = 8)

ggplot(database_merged) +
  geom_bar(aes(x=efficiency)) +
  labs(x="",y="Number of ocurrences")+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(plot.title = element_blank(), axis.text.x=element_text(angle=90,hjust=1,vjust=0.5,size=14),text = element_text(size = 14))   

ggsave("eficiencia_merged.png",height=8,width = 8)

## Smote : Synthetic Minority Oversampling Technique To Handle Class Imbalancy In Binary Classification
set.seed(42)
balanced.data <- smote(formula_efficiency, select(database, -filename))#, perc.over = 100, perc.under = 5)
ggplot(balanced.data) + geom_bar(aes(x=complexity_class))
ggplot(database) + geom_bar(aes(x=complexity_class))
ggplot(balanced.data) + geom_bar(aes(x=efficiency))
ggplot(database) + geom_bar(aes(x=efficiency))

balanced.data <- balanced.data %>% mutate_if(is.numeric,round)

ggplot(balanced.data) +
  geom_bar(aes(x=efficiency)) +
  labs(x="",y="Number of ocurrences")+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(plot.title = element_blank(), axis.text.x=element_text(angle=90,hjust=1,vjust=0.5,size=14),text = element_text(size = 14))   

ggsave("eficiencia-balanceado.png",height=8,width = 8)

ggplot(balanced.data) +
  geom_bar(aes(x=complexity_class)) +
  labs(x="",y="Number of ocurrences")+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(plot.title = element_blank(), axis.text.x=element_text(angle=90,hjust=1,vjust=0.5,size=14),text = element_text(size = 14))   
ggsave("classes-balanceado.png",height=8,width = 8)

#database <- balanced.data
#database <- balanced.data
balanced.data <- na.omit(balanced.data) 
summary(balanced.data)
ggplot(balanced.data) + geom_bar(aes(x=complexity_class))
set.seed(100)
train <- sample(nrow(balanced.data), 0.7*nrow(balanced.data), replace = FALSE)
TrainSet <- balanced.data[train,]
TrainSet <- droplevels(TrainSet)
ValidSet <- balanced.data[-train,]
ValidSet <- droplevels(ValidSet)
summary(TrainSet)
summary(ValidSet)

################################################################################
#Utilizando a base do paper para referência.

#select features trough boruta
set.seed(111)
boruta <- Boruta(efficiency ~ . -complexity_class -filename, data = database_paper, doTrace = 2, maxRuns = 500)
#print(boruta)
attStats(boruta)
formula_efficiency_paper<-getNonRejectedFormula(boruta)

#select features trough boruta
set.seed(111)
boruta <- Boruta(complexity_class ~ . -efficiency -filename, data = database_paper, doTrace = 2, maxRuns = 500)
#print(boruta)
attStats(boruta)
formula_class_paper<-getNonRejectedFormula(boruta)

balanced.data.paper <- smote(formula_efficiency_paper, select(database_paper, -filename))#, perc.over = 100, perc.under = 5)
balanced.data.paper <- balanced.data.paper %>% mutate_if(is.numeric,round)

ggplot(balanced.data.paper) +
  geom_bar(aes(x=efficiency)) +
  labs(x="",y="Number of ocurrences")+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(plot.title = element_blank(), axis.text.x=element_text(angle=90,hjust=1,vjust=0.5,size=14),text = element_text(size = 14))   

ggsave("eficiencia-balanceado-paper.png",height=8,width = 8)

ggplot(balanced.data.paper) +
  geom_bar(aes(x=complexity_class)) +
  labs(x="",y="Number of ocurrences")+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(plot.title = element_blank(), axis.text.x=element_text(angle=90,hjust=1,vjust=0.5,size=14),text = element_text(size = 14))   
ggsave("classes-balanceado-paper.png",height=8,width = 8)


balanced.data.paper <- na.omit(balanced.data.paper) 
summary(balanced.data.paper)
ggplot(balanced.data.paper) + geom_bar(aes(x=complexity_class))
set.seed(100)
train <- sample(nrow(balanced.data.paper), 0.7*nrow(balanced.data.paper), replace = FALSE)
TrainSetPaper <- balanced.data.paper[train,]
TrainSetPaper <- droplevels(TrainSetPaper)
ValidSetPaper <- balanced.data.paper[-train,]
ValidSetPaper <- droplevels(ValidSetPaper)
summary(TrainSetPaper)
summary(ValidSetPaper)


################################################################################
#Utilizando a base merged 

#select features trough boruta
set.seed(111)
boruta <- Boruta(efficiency ~ . -complexity_class -filename, data = database_merged, doTrace = 2, maxRuns = 500)
#print(boruta)
attStats(boruta)
formula_efficiency_merged<-getNonRejectedFormula(boruta)

#select features trough boruta
set.seed(111)
boruta <- Boruta(complexity_class ~ . -efficiency -filename, data = database_merged, doTrace = 2, maxRuns = 500)
#print(boruta)
attStats(boruta)
formula_class_merged<-getNonRejectedFormula(boruta)

balanced.data.merged <- smote(formula_efficiency_merged, select(database_merged, -filename))#, perc.over = 100, perc.under = 5)
balanced.data.merged<- balanced.data.merged %>% mutate_if(is.numeric,round)

balanced.data.merged <- na.omit(balanced.data.merged) 
summary(balanced.data.merged)

ggplot(balanced.data.merged) +
  geom_bar(aes(x=efficiency)) +
  labs(x="",y="Number of ocurrences")+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(plot.title = element_blank(), axis.text.x=element_text(angle=90,hjust=1,vjust=0.5,size=14),text = element_text(size = 14))   

ggsave("eficiencia-balanceado-merged.png",height=8,width = 8)

ggplot(balanced.data.merged) +
  geom_bar(aes(x=complexity_class)) +
  labs(x="",y="Number of ocurrences")+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(plot.title = element_blank(), axis.text.x=element_text(angle=90,hjust=1,vjust=0.5,size=14),text = element_text(size = 14))   
ggsave("classes-balanceado-merged.png",height=8,width = 8)


set.seed(100)
train <- sample(nrow(balanced.data.merged), 0.7*nrow(balanced.data.merged), replace = FALSE)
TrainSetMerged <- balanced.data.merged[train,]
TrainSetMerged <- droplevels(TrainSetMerged)
ValidSetMerged <- balanced.data.merged[-train,]
ValidSetMerged <- droplevels(ValidSetMerged)
summary(TrainSetMerged)
summary(ValidSetMerged)

################################################################################
## Modelo Random Forest
# Create a Random Forest model with default parameters
model_efficiency <- randomForest(formula_efficiency, data = TrainSet, ntree = 100, mtry = 3, importance = TRUE)
model_efficiency

#model for paper
model_efficiency_paper <- randomForest(formula_efficiency_paper, data = TrainSetPaper, ntree = 100, mtry = 3, importance = TRUE)
model_efficiency_paper

#model for merged
model_efficiency_merged <- randomForest(formula_efficiency_merged, data = TrainSetMerged, ntree = 100, mtry = 3, importance = TRUE)
model_efficiency_merged

#model for merged_full_set
model_efficiency_merged_full <- randomForest(formula_efficiency_merged, data = balanced.data.merged, ntree = 100, mtry = 3, importance = TRUE)
model_efficiency_merged_full
saveRDS(model_efficiency_merged_full, "model_efficiency_classification.rds")


#accuracy crawled validation set
p <- predict(model_efficiency, ValidSet)
confusionMatrix(p, ValidSet$efficiency, mode="everything")

#accuracy paper's validation dataset
p <- predict(model_efficiency_paper, ValidSetPaper)
confusionMatrix(p, ValidSetPaper$efficiency, mode="everything")

#accuracy merged validation set
p <- predict(model_efficiency_merged, ValidSetMerged)
confusionMatrix(p, ValidSetMerged$efficiency, mode="everything")

#accuracy merged validation set
p <- predict(model_efficiency_merged_full, ValidSetMerged)
confusionMatrix(p, ValidSetMerged$efficiency, mode="everything")

#accuracy crawled dataset
p <- predict(model_efficiency, database)
confusionMatrix(p, database$efficiency,mode="everything")

#accuracy paper's dataset using model from crawled
p <- predict(model_efficiency, database_paper)
confusionMatrix(p, database_paper$efficiency,mode="everything")

#accuracy paper's dataset using model from paper
p <- predict(model_efficiency_paper, database_paper)
confusionMatrix(p, database_paper$efficiency)

# Create a Random Forest model with default parameters using crawled dataset for training
bestmtry <- tuneRF(TrainSet,TrainSet$complexity_class,stepFactor=1.3, improve=0.01, trace=T, plot= T) 
print(bestmtry)
#TENTATIVA EM 28/09: avaliar a formula merged
model_classes <- randomForest(formula_class, data = TrainSet, ntree = 1000, importance = TRUE)
model_classes
model_classes$importance

# Create a Random Forest model with default parameters to predict class using Paper dataset
bestmtry <- tuneRF(TrainSetPaper,TrainSetPaper$complexity_class,stepFactor=1.3, improve=0.01, trace=T, plot= T) 
print(bestmtry)
model_classes_paper <- randomForest(formula_class_paper, data = TrainSetPaper, ntree = 1000, mtry = 5, importance = TRUE)
model_classes_paper

# Create a Random Forest model with default parameters to predict class using 70% merged dataset
bestmtry <- tuneRF(TrainSetMerged,TrainSetMerged$complexity_class,stepFactor=1.3, improve=0.01, trace=T, plot= T) 
print(bestmtry)
model_classes_merged <- randomForest(formula_class_merged, data = TrainSetMerged, ntree = 1000, mtry = 5, importance = TRUE)
model_classes_merged

# Create a Random Forest model with default parameters to predict class using 100% merged dataset
bestmtry <- tuneRF(TrainSetMerged,TrainSetMerged$complexity_class,stepFactor=1.3, improve=0.01, trace=T, plot= T) 
print(bestmtry)
model_classes_merged_full <- randomForest(formula_class_merged, data = balanced.data.merged , ntree = 128, mtry = 7, importance = TRUE)
model_classes_merged_full
saveRDS(model_classes_merged_full, "model_complexity_classification.rds")

#accuracy crawled validation dataset
p <- predict(model_classes, ValidSet)
confusionMatrix(p, ValidSet$complexity_class, mode="everything")

#accuracy from paper validation dataset 
p <- predict(model_classes_paper, ValidSetPaper)
confusionMatrix(p, ValidSetPaper$complexity_class)

#accuracy for classification on crawled dataset
p <- predict(model_classes, database)
confusionMatrix(p,database$complexity_class, mode="everything")

#accuracy for classification on validation merged dataset
p <- predict(model_classes_merged, ValidSetMerged)
confusionMatrix(p,ValidSetMerged$complexity_class, mode="everything")

#accuracy for classification on full merged dataset
p <- predict(model_classes_merged_full, ValidSetMerged)
confusionMatrix(p,ValidSetMerged$complexity_class, mode="everything")

#accuracy for classification on validation merged dataset
p <- predict(model_classes_merged, database_merged)
confusionMatrix(p,database_merged$complexity_class, mode="everything")

#accuracy for classification on paper dataset using proper model 
p <- predict(model_classes_paper, database_paper)
confusionMatrix(p,database_paper$complexity_class)

#accuracy paper's dataset using model from crawled
p <- predict(model_classes, database_paper)
database_paper$estimated_classes <- p
database_paper$correct <- as.character(database_paper$estimated_classes) == as.character(database_paper$complexity_class)
table(database_paper$estimated_classes,database_paper$complexity_class)
#Accuracy
sum(database_paper$correct)/nrow(database_paper)
summary(database_paper$complexity_class)

#accuracy paper's dataset using model from merged
p <- predict(model_classes_merged, database_paper)
database_paper$estimated_classes <- p
database_paper$correct <- as.character(database_paper$estimated_classes) == as.character(database_paper$complexity_class)
table(database_paper$estimated_classes,database_paper$complexity_class)
#Accuracy
sum(database_paper$correct)/nrow(database_paper)
summary(database_paper$complexity_class)

# MDA


varImpPlot(model_classes,
           sort = T,
           n.var = 3,
           main = "Top 3 - Variable Importance")

as.data.frame(importance(model_classes))

varImpPlot(model_classes_paper,
           sort = T,
           n.var = 3,
           main = "Top 3 - Variable Importance")

as.data.frame(importance(model_classes_paper))

varImpPlot(model_classes_merged,
           sort = T,
           n.var = 3,
           main = "Top 3 - Variable Importance")

as.data.frame(importance(model_classes_merged))



################################################################################
#Ideia: comparar a densidade das variáveis em cada classe em cada database para ver se existe interpolação.
target <- c("linear","linearithmic", "logarithmic")
database %>%
  dplyr::filter(complexity_class %in% target) %>%
  ggplot(aes(x=num_nasted_loop, color=complexity_class, fill=complexity_class)) +
  labs(y="Frequency density")+
  #geom_density()+
  #geom_histogram(aes(y=..density..), alpha=0.5, position="identity")+
  geom_density(alpha=.5) +
  scale_fill_viridis(discrete = T)+
  scale_color_viridis(discrete = T)+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(legend.position = c(0.9,0.9))+
  theme(plot.title = element_blank(),text = element_text(size = 16), legend.title=element_blank())  

ggsave("density-crawled-loop.png",height=8,width = 8)

database_paper %>%
  dplyr::filter(complexity_class %in% target) %>%
  ggplot(aes(x=num_nasted_loop, color=complexity_class, fill=complexity_class)) +
  labs(y="Fequency density")+
  #geom_density()+
  #geom_histogram(aes(y=..density..), alpha=0.5, position="identity")+
  geom_density(alpha=.5) +
  scale_fill_viridis(discrete = T)+
  scale_color_viridis(discrete = T)+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(legend.position = c(0.9,0.9))+
  theme(plot.title = element_blank(),text = element_text(size = 16), legend.title=element_blank())  

ggsave("density-paper-loop.png",height=8,width = 8)


target <- c("quadratic","polynomial","exponential")
database_merged %>%
  dplyr::filter(complexity_class %in% target) %>%
  ggplot(aes(x=num_vari, color=complexity_class, fill=complexity_class)) +
  labs(y="Frequency density")+
  #geom_density()+
  geom_density(alpha=.5) +
  scale_fill_viridis(discrete = T)+
  scale_color_viridis(discrete = T)+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(legend.position = c(0.9,0.9))+
  theme(plot.title = element_blank(),text = element_text(size = 16), legend.title=element_blank())  

ggsave("density-crawled-vari-inefficient.png",height=8,width = 8)

database_merged %>%
  dplyr::filter(complexity_class %in% target) %>%
  ggplot(aes(x=num_nasted_loop, color=complexity_class, fill=complexity_class)) +
  labs(y="Density")+
  #geom_density()+
  geom_histogram(aes(y=..density..), alpha=0.5, 
                 position="identity")+
  geom_density(alpha=.2) +
  scale_fill_viridis(discrete = T)+
  scale_color_viridis(discrete = T)+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(legend.position = c(0.9,0.9))+
  theme(plot.title = element_blank(),text = element_text(size = 16), legend.title=element_blank())  

ggsave("density-crawled-loop-inefficient.png",height=8,width = 8)

database_merged %>%
  dplyr::filter(complexity_class %in% target) %>%
  ggplot(aes(x=num_recursive, color=complexity_class, fill=complexity_class)) +
  labs(y="Density")+
  #geom_density()+
  geom_histogram(aes(y=..density..), alpha=0.5, 
                 position="identity")+
  geom_density(alpha=.2) +
  scale_fill_viridis(discrete = T)+
  scale_color_viridis(discrete = T)+
  theme_bw()+
  theme(text = element_text(family = "Arial"))+
  theme(legend.position = c(0.9,0.9))+
  theme(plot.title = element_blank(),text = element_text(size = 16), legend.title=element_blank())  

ggsave("density-crawled-recursive-inefficient.png",height=8,width = 8)

################################################################################
## decision tree
model_dt = train(formula_class, data = TrainSet, method = "rpart")
model_dt_1 = predict(model_dt, data = TrainSet)
table(model_dt_1, TrainSet$complexity_class)
mean(model_dt_1 == TrainSet$complexity_class)

################################################################################
## Modelo Multinomial

#Apontando a categoria de referência
balanced.data$complexity_class <- relevel(balanced.data$complexity_class, 
                                        ref = "linear")
#Estimação do modelo - função multinom do pacote nnet
modelo_multinomial <- multinom(formula = formula_class, 
                            data = balanced.data)
#Parâmetros do modelo_atrasado
summary(modelo_multinomial)
exp(coef(modelo_multinomial))
head(round(fitted(modelo_multinomial), 2))
database$complexity_class_predict <- predict(modelo_multinomial,newdata = database,class="complexity_class")
confusionMatrix(database$complexity_class_predict, database$complexity_class)

################################################################################
## Modelo de redes neurais
#TODO

set.seed(42)
TrainSet <- TrainSet %>% mutate(efficiency=as_factor(efficiency))
ValidSet <- ValidSet %>% mutate(efficiency=as_factor(efficiency))

threads <- 2
blas_set_num_threads(threads)
omp_set_num_threads(threads)
nnet<-neuralnet(formula_efficiency, TrainSet, hidden = c(8,1), linear.output = FALSE)
# https://www.thearmchaircritic.org/tech-journal/build-a-multi-class-classification-neural-network-in-r-in-fifty-lines-of-code

predicta <- function(data){ 
  prediction <- data.frame(neuralnet::compute(nnet,  
                                              data.frame(data[,]))$net.result) 
  labels <- c("efficient", "inefficient") 
  prediction_label <- data.frame(max.col(prediction)) %>%  
    mutate(prediction=labels[max.col.prediction.]) %>%  
    select(2) %>%  
    unlist() 
  table(data$efficiency, prediction_label)
  #confusionMatrix(prediction_label,data$efficiency)
}

predicta(TrainSet)
