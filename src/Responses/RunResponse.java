/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Responses;

/**
 *
 * @author lucas
 */
public class RunResponse {
  private String Statistics;
  private String AIndex;

  public String getStatistics()
  {
    return this.Statistics;
  }

  public void setStatistics(String Statistics) {
    this.Statistics = Statistics;
  }

  public String getAIndex() {
    return this.AIndex;
  }

  public void setAIndex(String AIndex) {
    this.AIndex = AIndex;
  }
}
