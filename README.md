# Unified Game Launcher
## Description
A comprehensive tool to pool games from various launchers together to allow a much more streamlined and efficient method to access various games and start them quickly. It provides a streamlined way to locate game executables and manage game files, enhancing user experience by simplifying the access and organization of games installed from different sources.

## Features

### Multi-Launcher Support
- Customized Readers: Implements unique readers for different game launchers, each tailored to the specific directory structure and features of the launcher (Steam, Xbox, Epic Games, etc.).

### Deep Directory Search
- Recursive Search: Utilizes a recursive search strategy to navigate through various directory depths to find game executables, ensuring no game is left undiscovered regardless of its installation depth.
- Filtering Mechanism: Employs a flexible filtering system to exclude unnecessary or unrelated files and directories, focusing solely on relevant game directories.

### Executable Validation
- Executable Finder: Integrates an executable validation system that locates the most likely game executable based on advanced matching algorithms.
- Levenshtein Distance Algorithm: Utilizes the Levenshtein distance algorithm to ensure the found executables closely match expected game names, minimizing false positives.

## System Integration
- Directory Monitoring: Monitors directories for changes, keeping the game list updated and accurate.
- Performance Optimized: Designed with performance in mind, ensuring quick and efficient directory traversal and game executable identification.

## Utilization of Technologies
Scala: Developed in Scala, providing a robust and efficient foundation for handling complex directory structures and implementing sophisticated algorithms.
FileFilter and Recursion: Uses Scala's FileFilter for directory navigation and recursion for deep searching, ensuring comprehensive coverage of all directories.

## Planned Features
- Dynamic Path Configuration: Allows users to set or change the path for each launcher's directory, accommodating custom installations and setups.
- Increased search optimisation: To allow for accomadation with more launcers and custom game installations.
