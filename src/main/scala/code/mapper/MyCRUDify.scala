package ca.dualityStudios.liftAuthentication.model

import net.liftweb.mapper._
import net.liftweb.http.{S}
import scala.xml._

trait MyCRUDify[KeyType, CrudType <: KeyedMapper[KeyType, CrudType]] 
  extends net.liftweb.mapper.CRUDify[KeyType, CrudType]
{
  
	self: CrudType with KeyedMetaMapper[KeyType, CrudType] =>
	
	
	override def pageWrapper(body: NodeSeq): NodeSeq = <lift:surround with="default" at="content">{body}</lift:surround>
	
	override def _viewTemplate = {
		<lift:crud.view>
			<table id={viewId} class={viewClass}>
				<crud:row>
					<tr>
						<td><crud:name/></td>
						<td><crud:value/></td>
					</tr>
				</crud:row>
			</table>
		</lift:crud.view>
	}
	
	override def _createTemplate = {
		<lift:crud.create form="post">
			<table id={createId} class={createClass}>
				<crud:field>
					<tr>
						<td>
							<crud:name/>
						</td>
						<td>
							<crud:form/>
						</td>
					</tr>
				</crud:field>
				<tr>
					<td>&nbsp;</td>
					<td><crud:submit>{createButton}</crud:submit></td>
				</tr>
			</table>
		</lift:crud.create>
	}
	
	protected override def _editTemplate = {
		<lift:crud.edit form="post">
			<table id={editId} class={editClass}>
				<crud:field>
					<tr>
						<td>
							<crud:name/>
						</td>
						<td>
							<crud:form/>
						</td>
					</tr>
				</crud:field>
				<tr>
					<td>&nbsp;</td>
					<td><crud:submit>{editButton}</crud:submit></td>
				</tr>
			</table>
		</lift:crud.edit>
  }
	
	override def _deleteTemplate = {
		<lift:crud.delete form="post">
			<table id={deleteId} class={deleteClass}>
				<crud:field>
					<tr>
						<td>
							<crud:name/>
						</td>
						<td>
							<crud:value/>
						</td>
					</tr>
				</crud:field>

				<tr>
					<td>&nbsp;</td>
					<td><crud:submit>{deleteButton}</crud:submit></td>
				</tr>
			</table>
		</lift:crud.delete>
	}
	
	override def _showAllTemplate = {
		<lift:crud.all>
			<table id={showAllId} class={showAllClass}>
				<thead>
					<tr>
						<crud:header_item><th><crud:name/></th></crud:header_item>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<crud:row>
						<tr>
							<crud:row_item><td><crud:value/></td></crud:row_item>
							<td><a crud:view_href="">{S.??("View")}</a></td>
							<td><a crud:edit_href="">{S.??("Edit")}</a></td>
							<td><a crud:delete_href="">{S.??("Delete")}</a></td>
						</tr>
					</crud:row>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="3"><crud:prev>{previousWord}</crud:prev></td>
						<td colspan="3"><crud:next>{nextWord}</crud:next></td>
					</tr>
				</tfoot>
			</table>
		</lift:crud.all>
	}
}