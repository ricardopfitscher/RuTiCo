import pandas as pd 
import matplotlib.pyplot as plt 
import seaborn as sn 
%matplotlib inline 
#used for class balancing
from imblearn.over_sampling import SMOTE

crawled_database = pd.read_csv('/kaggle/input/merged-dataset/database.csv')#crawled data
paper_database = pd.read_csv('/kaggle/input/merged-dataset/database_paper.csv')#reference data
merged_database = pd.merge(crawled_database, paper_database, how='outer')#merged data


from sklearn.metrics import accuracy_score, precision_score, recall_score, f1_score


#function to calculate the metrics of the models
def metrics(y_test, y_pred):
    accuracy = accuracy_score(y_test, y_pred)
    precision = precision_score(y_test, y_pred, average='weighted', zero_division=1)
    recall = recall_score(y_test, y_pred, average='weighted', zero_division=1)
    f1 = f1_score(y_test, y_pred, average='weighted', zero_division=1)

    print('Model accuracy score: {0:0.4f}'.format(accuracy))
    print('Model precision score: {0:0.4f}'.format(precision))
    print('Model recall score: {0:0.4f}'.format(recall))
    print('Model F1 score: {0:0.4f}'.format(f1))

#function to visualize the features
def features_visualization(rfc, x_train):
    feature_scores = pd.Series(rfc.feature_importances_, index=x_train.columns).sort_values(ascending=False)

    sn.barplot(x=feature_scores, y=feature_scores.index)
    plt.xlabel('Feature Importance Score')
    plt.ylabel('Features')
    plt.show()

#definition of the features applied for each database based on BORUTA

#complexity class for crawled
x_crawled_class = crawled_database.drop(['complexity', 'complexity_class', 'efficiency','filename','num_switch','num_break', 'num_Priority','num_hash_map','num_sort'], axis = 1) 
y_crawled_class = crawled_database['complexity_class']

#efficiency for crawled
x_crawled_efficiency = crawled_database.drop(['complexity', 'complexity_class', 'efficiency','filename','num_else','num_binSearch','num_switch','num_hash_set','num_break', 'num_Priority','num_hash_map','num_sort'], axis = 1) 
y_crawled_efficiency = crawled_database['efficiency']


############################################################################################

#complexity class for reference
x_paper_class = paper_database.drop(['complexity', 'complexity_class', 'efficiency','filename','num_switch','num_hash_set'], axis = 1) 
y_paper_class = paper_database['complexity_class']

#efficiency for reference
x_paper_efficiency = paper_database.drop(['complexity', 'complexity_class', 'efficiency','filename','num_switch','num_hash_set','num_binSearch'], axis = 1) 
y_paper_efficiency = paper_database['efficiency']

############################################################################################

#complexity class for merged
x_merged_class = merged_database.drop(['complexity', 'complexity_class', 'efficiency','filename','num_switch'], axis = 1) 
y_merged_class = merged_database['complexity_class']

#efficiency for merged
x_merged_efficiency = merged_database.drop(['complexity', 'complexity_class', 'efficiency','filename','num_switch','num_break', 'num_Priority','num_hash_set'], axis = 1) 
y_merged_efficiency = merged_database['efficiency']

############################################################################################

#complexity class for testing with reference data and trained with the crawled data
x_paper_crawled_class = paper_database.drop(['complexity', 'complexity_class', 'efficiency','filename','num_switch','num_break', 'num_Priority','num_hash_map','num_sort'], axis = 1) 
y_paper_crawled_class = paper_database['complexity_class']

#efficiency for testing with reference data and trained with the crawled data
x_paper_crawled_efficiency = paper_database.drop(['complexity', 'complexity_class', 'efficiency','filename','num_else','num_binSearch','num_switch','num_hash_set','num_break', 'num_Priority','num_hash_map','num_sort'], axis = 1) 
y_paper_crawled_efficiency = paper_database['efficiency']


############################################################################################
                   

#applying SMOTE for class balancing

sm = SMOTE(random_state=42, k_neighbors=1)

#complexity class for crawled
x_crawled_class, y_crawled_class = sm.fit_resample(x_crawled_class, y_crawled_class)
#efficiency for crawled
x_crawled_efficiency, y_crawled_efficiency = sm.fit_resample(x_crawled_efficiency, y_crawled_efficiency)
#complexity class for reference
x_paper_class, y_paper_class = sm.fit_resample(x_paper_class, y_paper_class)
#efficiency for reference
x_paper_efficiency, y_paper_efficiency = sm.fit_resample(x_paper_efficiency, y_paper_efficiency)
#complexity class for merged
x_merged_class, y_merged_class = sm.fit_resample(x_merged_class, y_merged_class)
#efficiency for merged
x_merged_efficiency, y_merged_efficiency = sm.fit_resample(x_merged_efficiency, y_merged_efficiency)

############################################################################################

from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import classification_report, confusion_matrix

#creating an instance of the RandomForestClassifier
rfc = RandomForestClassifier(random_state=42)


############################################################################################

#Random Forest applied to the crawled dataset training the models with a sample of 70% and testing with the 30% remaining data


#Prediction of the complexity class

#stratified data division
x_train, x_test, y_train, y_test = train_test_split(x_crawled_class, y_crawled_class, test_size = 0.30, stratify = y_crawled_class, random_state = 42)

#training the model
rfc.fit(x_train, y_train)

#predicting the target variable
y_pred = rfc.predict(x_test)

#metrics

print('Metrics for the complexity class applied to the crawled database')
metrics(y_test, y_pred)

#feature visualization

plt.title("Visualizing Important Features for Complexity Class on the Crawled Database")
features_visualization(rfc, x_train)

cm = confusion_matrix(y_test, y_pred)

print('Confusion matrix for the complexity class on crawled\n\n', cm)
print('\nClassification report for the complexity class on crawled\n',classification_report(y_test, y_pred))

print('\n\n')

#Prediction of the efficiency

#stratified data division
x_train, x_test, y_train, y_test = train_test_split(x_crawled_efficiency, y_crawled_efficiency, test_size = 0.30, stratify = y_crawled_efficiency, random_state = 42)

#training the model
rfc.fit(x_train, y_train)

#predicting the target variable
y_pred = rfc.predict(x_test)

#metrics

print('Metrics for the efficiency applied to the crawled database')
metrics(y_test, y_pred)

#feature visualization

plt.title("Visualizing Important Features for Efficiency on the Crawled Database")
features_visualization(rfc, x_train)

cm = confusion_matrix(y_test, y_pred)

print('Confusion matrix for the efficiency on crawled\n\n', cm)
print('\nClassification report for the efficiency on crawled\n',classification_report(y_test, y_pred))

print('\n\n\n')

############################################################################################

#Random Forest applied to the reference dataset training the models with a sample of 70% and testing with the 30% remaining data


#Prediction of the complexity class

#stratified data division
x_train, x_test, y_train, y_test = train_test_split(x_paper_class, y_paper_class, test_size = 0.30, stratify = y_paper_class, random_state = 42)

#training the model
rfc.fit(x_train, y_train)

#predicting the target variable
y_pred = rfc.predict(x_test)

#metrics

print('Metrics for the complexity class applied to the reference database')

metrics(y_test, y_pred)

#feature visualization

plt.title("Visualizing Important Features for Complexity Class on the Reference Database")
features_visualization(rfc, x_train)

cm = confusion_matrix(y_test, y_pred)

print('Confusion matrix for the complexity class on reference\n\n', cm)
print('\nClassification report for the complexity class on reference\n',classification_report(y_test, y_pred))

print('\n\n')

#Prediction of the efficiency

#stratified data division
x_train, x_test, y_train, y_test = train_test_split(x_paper_efficiency, y_paper_efficiency, test_size = 0.30, stratify = y_paper_efficiency, random_state = 42)

#training the model
rfc.fit(x_train, y_train)

#predicting the target variable
y_pred = rfc.predict(x_test)

#metrics

print('Metrics for the efficiency applied to the reference database')

metrics(y_test, y_pred)

#feature visualization

plt.title("Visualizing Important Features for Efficiency on the Reference Database")
features_visualization(rfc, x_train)

cm = confusion_matrix(y_test, y_pred)

print('Confusion matrix for the efficiency on reference\n\n', cm)
print('\nClassification report for the efficiency on reference\n',classification_report(y_test, y_pred))

print('\n\n\n')

############################################################################################

#Random Forest applied to the merged dataset training the models with a sample of 70% and testing with the 30% remaining data


#Prediction of the complexity class

#stratified data division
x_train, x_test, y_train, y_test = train_test_split(x_merged_class, y_merged_class, test_size = 0.30, stratify = y_merged_class, random_state = 42)

#training the model
rfc.fit(x_train, y_train)

#predicting the target variable
y_pred = rfc.predict(x_test)

#metrics

print('Metrics for the complexity class applied to the merged database')

metrics(y_test, y_pred)

#feature visualization

plt.title("Visualizing Important Features for Complexity Class on the Merged Database")
features_visualization(rfc, x_train)

cm = confusion_matrix(y_test, y_pred)

print('Confusion matrix for the complexity class on merged\n\n', cm)
print('\nClassification report for the complexity class on merged\n',classification_report(y_test, y_pred))

print('\n\n')

#Prediction of the efficiency

#stratified data division
x_train, x_test, y_train, y_test = train_test_split(x_merged_efficiency, y_merged_efficiency, test_size = 0.30, stratify = y_merged_efficiency, random_state = 42)

#training the model
rfc.fit(x_train, y_train)

#predicting the target variable
y_pred = rfc.predict(x_test)

#metrics

print('Metrics for the efficiency applied to the merged database')

metrics(y_test, y_pred)

#feature visualization

plt.title("Visualizing Important Features for Efficiency on the Merged Database")
features_visualization(rfc, x_train)

cm = confusion_matrix(y_test, y_pred)

print('Confusion matrix for the efficiency on merged\n\n', cm)
print('\nClassification report for the efficiency on merged\n',classification_report(y_test, y_pred))

print('\n\n\n')

############################################################################################

#Random Forest applied using 70% of the data from the crawled dataset for training and 100% of the data from the reference dataset for testing


#Prediction of the complexity class

#stratified data division
x_train, x_test, y_train, y_test = train_test_split(x_crawled_class, y_crawled_class, test_size = 0.30, stratify = y_crawled_class, random_state = 42)

#training the model
rfc.fit(x_train, y_train)

#using the reference data for the tests
x_test = x_paper_crawled_class
y_test = y_paper_crawled_class

#predicting the target variable
y_pred = rfc.predict(x_test)

#metrics

print('Metrics for the complexity class applied to the reference database trained with the crawled database')

metrics(y_test, y_pred)

#feature visualization

plt.title("Visualizing Important Features for Complexity Class on the Reference Database Trained with the Crawled Database")
features_visualization(rfc, x_train)

cm = confusion_matrix(y_test, y_pred)

print('Confusion matrix for the complexity class on reference database trained with the crawled database\n\n', cm)
print('\nClassification report for the complexity class on reference database trained with the crawled database\n',classification_report(y_test, y_pred, zero_division = 1))

print('\n\n')

#Prediction of the efficiency

#stratified data division
x_train, x_test, y_train, y_test = train_test_split(x_crawled_efficiency, y_crawled_efficiency, test_size = 0.30, stratify = y_crawled_efficiency, random_state = 42)

#training the model
rfc.fit(x_train, y_train)

#using the reference data for the tests
x_test = x_paper_crawled_efficiency
y_test = y_paper_crawled_efficiency

#predicting the target variable
y_pred = rfc.predict(x_test)

#metrics
print('Metrics for the efficiency applied to the reference database trained with the crawled database')
metrics(y_test, y_pred)

#feature visualization
plt.title("Visualizing Important Features for Efficiency on the Reference Database trained with the Crawled Database")
features_visualization(rfc, x_train)

cm = confusion_matrix(y_test, y_pred)

print('Confusion matrix for the efficiency on reference database trained with the crawled database\n\n', cm)
print('\nClassification report for the efficiency on reference database trained with the crawled database\n',classification_report(y_test, y_pred))

print('\n\n\n')
