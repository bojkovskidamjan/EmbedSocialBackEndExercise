# Review Filter and Sorting Tool

## Overview

The Review Filter and Sorting Tool is a Python-based application that allows users to filter and sort reviews based on various criteria. It provides flexibility in organizing and displaying reviews, making it easier to extract valuable insights from review data.

## Features

- **Sort by Text:** Prioritize reviews with text (Yes/No).
- **Sort by Rating:** Order reviews by highest or lowest rating.
- **Sort by Date:** Arrange reviews by newest or oldest first.
- **Filter by Minimum Rating:** Display reviews with ratings equal to or higher than a specified value.

## Getting Started

1. Clone or download this repository to your local machine.

2. Ensure you have a file named `reviews.json` containing your review data. You can use the provided `reviews.json` as a sample or create your own with a similar structure.

3. Open your terminal and navigate to the project directory.

4. Run the application 

5. Open the localhost port http://localhost:8080/reviews

## Example

Suppose you have configured the following preferences:

- **Prioritize by Text:** Yes
- **Sort by Rating:** Highest First
- **Sort by Date:** Oldest First
- **Minimum Rating:** 3
  
The reviews will be displayed in the following order:

1. 5-star reviews with text - oldest first
2. 4-star reviews with text - oldest first
3. 3-star reviews with text - oldest first
4. 5-star reviews without text - oldest first
5. 4-star reviews without text - oldest first
6. 3-star reviews without text - oldest first
   
If you set "Prioritize by Text" to 'No', it won't affect the order of reviews; they will be sorted and filtered based on the other criteria you selected.
