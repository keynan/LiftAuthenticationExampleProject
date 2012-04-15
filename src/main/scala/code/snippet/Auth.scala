package code.snippet

import ca.dualityStudios.liftAuthentication.model._
import ca.dualityStudios.liftAuthentication._
import net.liftweb.http._

object Auth 
	extends StatefulSnippet 
	with AuthenticationHelpers {
	
	def MetaUser = User
}