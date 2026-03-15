# Software System Quality Evaluation (ISO/IEC 25010 & 25023)

## Course: SENG 272 - Lab 2

## Description
A Java measurement tool that evaluates software quality using ISO/IEC 25010 quality characteristics and ISO/IEC 250023 matrices.

## Features
- Evaluates multiple software systems (Web, Mobile, Enterprise)
- Calculates metric score using standardized formulas
- Generates quality reports with dimension scores and labels
- Identifies weakest quality dimension

## ISO/IEC 25010 Quality Model
The software product quality model defines 8 primary  characteristics:
1. **Functional Suitability**: Completeness, Correctness, Appropriateness.
2. **Performance Efficiency**: Time Behaviour, Resource Utilisation, Capacity.
3. **Compatibility**: Co-existence, Interoperability.
4. **Usability**: Appropriateness Recognisability, Learnability, Operability, User Error
   Protection, UI Aesthetics, Accessibility.
5. **Reliability**: Maturity, Availability, Fault Tolerance, Recoverability.
6. **Security**: Confidentiality, Integrity, Non-repudiation, Accountability, Authenticity.
7. **Maintainability**: Modularity, Reusability, Analysability, Modifiability, Testability.
8. **Portability**: Adaptability, Installability, Replaceability.


## ISO/IEC 25023 Metrics Reference
| Quality Characteristic     | Metric Name                   | Direction | Unit | Formula Summary                     |
|----------------------------|-------------------------------|-----------|------|-------------------------------------|
| **Functional Suitability** | Functional Completeness Ratio | Higher | % | Implemented functions / Planned functions × 100 |
| | Functional Correctness Ratio | Higher | % | Correct-output tests / Total tests × 100 |
||
| **Reliability**            | Availability Ratio            | Higher | % | Uptime / (Uptime + Downtime) × 100 |
|                            | Defect Density                | Lower | defect/KLOC | Defects found / 1000 LOC |
|                            | MTBF                          | Higher | hours | Total operation time / Number of failures |
||
| **Performance Efficiency** | Response Time                 | Lower | ms | Average end-to-end response time |
|                            | Throughput                    | Higher | req/s | Requests processed per second |
|                            | CPU Utilisation Ratio         | Lower | % | CPU used / Total CPU × 100 |
||
| **Usability**              | Task Completion Rate          | Higher | % | Completed tasks / Total attempted tasks × 100 |
|                            | User Error Rate               | Lower | % | Error operations / Total operations × 100 |
||
| **Security**               | Security Test Coverage        | Higher | % | Passed security tests / Total security tests × 100 |
|                            | Vulnerability Count           | Lower | count | Number of detected vulnerabilities |
||
| **Maintainability**        | Test Coverage Ratio           | Higher | % | Tested LOC / Total LOC × 100 |
|                            | Cyclomatic Complexity (avg)   | Lower | score | Average cyclomatic complexity per module |

## Classes
- Criterion - A single quality metric
- QualityDimension - Groups related criteria
- SWSystem - Software system being evaluated
- SWSystemData - Creates test data
- Main - Starting point

## ISO/IEC 25010 Quality Characteristics
- Functional Suitability
- Performance Efficiency
- Compatibility
- Usability
- Reliability
- Security
- Maintainability
- Portability
